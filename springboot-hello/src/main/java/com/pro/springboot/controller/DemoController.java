package com.pro.springboot.controller;

import com.itextpdf.text.DocumentException;
import com.pro.springboot.dto.PageResult;
import com.pro.springboot.dto.RegisterDTO;
import com.pro.springboot.dto.User;
import com.pro.springboot.image.ImageDTO;
import com.pro.springboot.image.ImageMapper;
import com.pro.springboot.pdf.PdfService;
import com.pro.springboot.result.MyException;
import com.pro.springboot.result.Result;
import com.pro.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private PdfService pdfService;

    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    @RequestMapping(value="/showAllUser",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<User>> showAllUser(@RequestParam(value = "page") int page , int limit) {
        List<User> users = getAllUser(); // 数据库获取数据
        //返回的总记录数（你自己的分页）
        PageResult<List<User>> listPageResult=new PageResult<List<User>>("",users,0,users.size());
        return listPageResult;
    }

    @RequestMapping(value="/selectUserByPhone",method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<User>> selectUserByPhone(@RequestParam(value = "page") int page , int limit,String phone) {

        List<User> users = getAllUser();
        List<User> userList = users.stream().filter(user -> user.getPhone().equals("12345678911")).collect(Collectors.toList());

        // 你自己的分页
        PageResult<List<User>> listPageResult=new PageResult<List<User>>("",userList,0,userList.size());
        return listPageResult;
    }



    public List<User> getAllUser()
    {
        List<User> userList = new ArrayList<>();
        for(int i = 0; i<=6; i++)
        {
            User user = new User();
            user.setId(i+1);
            user.setFname("小明"+i);
            user.setPhone("1234567891"+i);
            user.setEmail("1214296077@qq.com");
            user.setPassword("123");
            user.setName("admin");
            user.setIdcard("121323434343435");
            user.setHeadimg("qwqwqw");
            user.setIntroduce("ewewewewe");
            user.setRtime("2020-12-21");
            userList.add(user);
        }
        return userList;
    }

    @RequestMapping("/banner")
    public String toPage()
    {
        return "banner";
    }

    @PostMapping("/testRedis")
    @ResponseBody
    public Result getRedisValue()
    {

        Object aa = redisTemplate.opsForValue().get("aa");
        Boolean flag = redisTemplate.hasKey("aa");
        System.out.println(flag);

        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name","张三");
        valueMap.put("age",18);
        redisTemplate.opsForHash().put("demo","demoKey", valueMap);
        Object bb = redisTemplate.opsForHash().get("demo","demoKey");
        return Result.success(aa);
    }

    /**
     * 刷新ldap中员工的数据
     *
     * @return
     */
    @RequestMapping("/toPage")
    @ResponseBody
    public List<String> updateAllPerson(HttpServletRequest request) {
        //baseService.queryAllPerson();
        List<String> list =new ArrayList<>();
        list.add("11111");

        return list;
    }

    @RequestMapping(value = "/testException", method = RequestMethod.POST)
    @ResponseBody
    public String index() {
        throw new MyException("测试");
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@Valid @RequestBody RegisterDTO registerDTO)
    {
        String result = userService.registerUser(registerDTO);
        return Result.success(result);
    }

    @RequestMapping(value = "/createPdf", method = RequestMethod.GET)
    public void createPdf(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, DocumentException {
        response.setContentType("application/pdf;charset=UTF-8");
        pdfService.generatePDF(response);
//        pdfService.createPdf();
    }

}
