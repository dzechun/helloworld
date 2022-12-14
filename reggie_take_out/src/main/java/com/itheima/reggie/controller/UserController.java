package com.itheima.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.com.R;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 发送手机短信验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //生成4位随机验证码
            String code = ValidateCodeUtils.generateValidateCode(4);
            log.info("code={}",code);
            //调用国阳云提供的短信服务API并发送短信
//            sSMSUtils.sendMessage(phone,code);

            //需要将生成的验证码保存到session
//            session.setAttribute(phone,code);

            //将生成的验证码保存到redis中,并设置五分钟有效期
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("手机验证码短信发送成功");
        }
        return R.error("手机验证码短信发送失败");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){
        log.info(map.toString());

        //获取手机号
        String phone = map.get("phone").toString();

        //获取验证码
        String code = map.get("code").toString();

        //从session中获取保存的验证码
//        Object codeInSession = session.getAttribute(phone);

        //从redis中获取保存到饿验证码
        String codeInSession = (String) redisTemplate.opsForValue().get(phone);

        //进行验证码的比对（页面提交的验证码和session中保存的验证码比对）
        if(codeInSession != null && codeInSession.equals(code)){

            //如果对比成功，说明登录成功
            //判断当前手机号是否是新用户，如果是新用户就自动完成注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            log.info("" + session.getAttribute("user"));

            //登录成功后删除redis中保存的验证码
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("登录失败");
    }

}
