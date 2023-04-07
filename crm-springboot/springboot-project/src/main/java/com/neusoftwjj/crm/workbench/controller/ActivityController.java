package com.neusoftwjj.crm.workbench.controller;

import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.commons.utils.HSSFUtils;
import com.neusoftwjj.crm.commons.utils.UUIDUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.settings.service.UserService;
import com.neusoftwjj.crm.workbench.activity.model.Activity;
import com.neusoftwjj.crm.workbench.activity.model.ActivityRemark;
import com.neusoftwjj.crm.workbench.activity.service.ActivityRemarkService;
import com.neusoftwjj.crm.workbench.activity.service.ActivityService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

@Controller
public class ActivityController {
    @Resource
    private UserService userService;
    @Resource
    private ActivityService activityService;
    @Resource
    private ActivityRemarkService activityRemarkService;

    @GetMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request) {

        //调用service层方法,查询所有用户
        List<User> userList = userService.queryAllUsers();
        //把数据保存至request中
        request.setAttribute("userList", userList);
        //跳转index页面
        return "workbench/activity/index";
    }

    //保存市场活动信息
    @PostMapping("/workbench/activity/saveCreateActivity.do")
    public @ResponseBody
    Object saveCreateActivity(Activity activity, HttpSession session) {
        //继续封装实体类
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject = new ReturnObject();
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateBy(user.getId());
        activity.setCreateTime(DateUtils.formateDateTime(new Date()));
        //调Service层方法,保存信息
        try {
            int ret = activityService.saveCreateActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后再试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后再试...");
        }
        return returnObject;
    }

    @GetMapping("/workbench/activity/queryActivityByConditionForPage.do")
    public @ResponseBody
    Object queryActivityByConditionForPage(String name, String owner, String startDate, String endDate,
                                           @RequestParam(value = "pageNo", required = false) int pageNo, @RequestParam(value = "pageSize", required = false) int pageSize) {
        System.out.println("数值:" + pageNo);
        System.out.println("条数" + pageSize);
        //封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("beginNo", (pageNo - 1) * pageSize);
        System.out.println(map.get("beginNo"));
        map.put("pageSize", pageSize);
        //调用service层方法,查询数据
        List<Activity> activityList = activityService.queryActivityByConditionForPage(map);
        int totalRows = activityService.queryCountOfActivityByCondition(map);
        //根据查询结果,生成响应信息
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("activityList", activityList);
        retMap.put("totalRows", totalRows);
        return retMap;

    }

    @DeleteMapping("/workbench/activity/deleteActivityByIds.do")
    public @ResponseBody
    Object deleteActivityByIds(String[] id) {
        System.out.println(id);
        ReturnObject returnObject = new ReturnObject();
        try {
            //调用service层方法,实现删除
            int ret = activityService.deleteActivityByIds(id);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后再试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后再试...");
        }
        return returnObject;
    }

    @GetMapping("/workbench/activity/queryActivityById.do")
    public @ResponseBody
    Object queryActivityById(String id) {
        //调用service层方法
        Activity activity = activityService.queryActivityById(id);
        return activity;
    }

    @PostMapping("/workbench/activity/saveEditActivity.do")
    public @ResponseBody
    Object saveEditActivity(Activity activity, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        System.out.println("成本--" + activity.getCost());
        //封装参数
        activity.setEditTime(DateUtils.formateDateTime(new Date()));
        activity.setEditBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        //调用service层方法,实现保存修改
        try {
            int ret = activityService.saveEditActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统繁忙,请稍后再试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后再试...");
        }
        return returnObject;
    }

    @GetMapping("/workbench/activity/exportAllActivitys.do")
    public @ResponseBody
    void exportAllActivitys(HttpServletResponse response) throws Exception {
        //调用service层方法
        List<Activity> activityList = activityService.queryAllActivitys();
        //创建HSSFWorkbook对象,activityList写入对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //使用wb创建HSSFSheet对象,对应wb文件中的一页
        HSSFSheet sheet = wb.createSheet("市场活动列表");
        //使用sheet创建HSSFRow对象,对应sheet中的一行
        HSSFRow row = sheet.createRow(0);//行号,从0开始,递增
        //使用row创建HSSFCell对象,对应row的列
        HSSFCell cell = row.createCell(0);//列号,从0开始,递增
        //列值
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建时间");
        cell = row.createCell(8);
        cell.setCellValue("创建者");
        cell = row.createCell(9);
        cell.setCellValue("修改时间");
        cell = row.createCell(10);
        cell.setCellValue("修改者");

        //遍历activityList,创建HSSFRow对象
        if (activityList != null && activityList.size() > 0) {
            Activity activity = null;
            for (int i = 0; i < activityList.size(); i++) {
                activity = activityList.get(i);
                //获取对象
                row=sheet.createRow(i+1);
                cell = row.createCell(0);
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditTime());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditBy());
            }
        }
        //根据wb对象生成excel文件
       /* OutputStream os=new FileOutputStream("D:\\SSM框架CRM项目\\CRM项目（SSM框架版）\\项目资料\\项目资料\\serverDir\\ActivityList.xls");
        wb.write(os);//效率低
        //关闭资源
        os.close();
        wb.close();*/

        //文件下载
        //1.设置响应类型,响应头信息
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=ActivityList.xls");
        //2.获取输出流
        OutputStream out = response.getOutputStream();
        //3.读取excel文件,输出流输出到浏览器
       /* InputStream is=new FileInputStream("D:\\SSM框架CRM项目\\CRM项目（SSM框架版）\\项目资料\\项目资料\\serverDir\\ActivityList.xls");
        //4.缓冲区
        byte[] buff=new byte[1024];
        int len=0;
        //5.循环读取缓冲区
        while((len=is.read(buff))!=-1){
            out.write(buff,0,len);//效率低
        }*/
        //关闭资源
        //is.close();
        //直接不用写入磁盘,浏览器直接获取,效率高
        wb.write(out);
        wb.close();
        out.flush();
    }

    //文件上传,SpringMVC上传解析器
    @GetMapping("/workbench/activity/fileUpload.do")
    public Object fileUpload(String username, MultipartFile myFile) throws Exception {
        //把文件在服务指定的目录中生成一个同样的文件
        String filename = myFile.getOriginalFilename();
        File file = new File("D:\\SSM框架CRM项目\\CRM项目（SSM框架版）\\项目资料\\项目资料\\serverDir\\", filename);
        myFile.transferTo(file);
        //返回响应信息
        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("上传成功");
        return returnObject;
    }

    @PostMapping("/workbench/activity/importActivity.do")
    public @ResponseBody
    Object importActivity(MultipartFile activityFile, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        ReturnObject returnObject = new ReturnObject();
        try {
            //把文件在服务指定的目录中生成一个excel的文件
            /*String filename = activityFile.getOriginalFilename();
            File file = new File("D:\\SSM框架CRM项目\\CRM项目（SSM框架版）\\项目资料\\项目资料\\serverDir\\", filename);
            activityFile.transferTo(file);

            //解析excel文件,将获取文件的数据封装成activityList
            InputStream is = new FileInputStream("D:\\SSM框架CRM项目\\CRM项目（SSM框架版）\\项目资料\\项目资料\\serverDir\\" + filename);*/

            InputStream is = activityFile.getInputStream();//重写不入磁盘,效率快
            HSSFWorkbook wb = new HSSFWorkbook(is);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFCell cell = null;
            HSSFRow row = null;
            Activity activity = null;
            List<Activity> activityList = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {//sheet.getLastRowNum();最后一行下标
                row = sheet.getRow(i);
                activity = new Activity();
                activity.setId(UUIDUtils.getUUID());
                activity.setOwner(user.getId());
                activity.setCreateTime(DateUtils.formateDateTime(new Date()));
                activity.setCreateBy(user.getId());
                for (int j = 0; j < row.getLastCellNum(); j++) {//row.getLastCellNum();最后一列下标加一
                    //根据row获取HSSFCell对象,封装了一列所有的信息
                    cell = row.getCell(j);

                    //获取列中的数据
                    String cellValue = HSSFUtils.getCellValueForStr(cell);
                    if (j == 0) {
                        activity.setName(cellValue);
                    } else if (j == 1) {
                        activity.setStartDate(cellValue);
                    } else if (j == 2) {
                        activity.setEndDate(cellValue);
                    } else if (j == 3) {
                        activity.setCost(cellValue);
                    } else if (j == 4) {
                        activity.setDescription(cellValue);
                    }

                }
                //每一行数据保存到activityList
                activityList.add(activity);
            }
            //调用service层方法

            int ret = activityService.saveCreateActivityByList(activityList);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setRetData(ret);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统繁忙,请稍后再试...");
        }
        return returnObject;
    }
    /*@RequestMapping("/workbench/activity/activityDetail.do")
    public  String activityDetail(){
        return "workbench/activity/detail";
    }*/
    @GetMapping("/workbench/activity/exportActivityByIdList.do")
    public @ResponseBody void exportActivityByIdList(String[] id,HttpServletResponse response) throws Exception{
        //调用service层方法
        List<Activity> activityList=activityService.queryActivityByIdList(id);
        //创建HSSFWorkbook对象,activityList写入对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //使用wb创建HSSFSheet对象,对应wb文件中的一页
        HSSFSheet sheet = wb.createSheet("市场活动列表");
        //使用sheet创建HSSFRow对象,对应sheet中的一行
        HSSFRow row = sheet.createRow(0);//行号,从0开始,递增
        //使用row创建HSSFCell对象,对应row的列
        HSSFCell cell = row.createCell(0);//列号,从0开始,递增
        //列值
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建时间");
        cell = row.createCell(8);
        cell.setCellValue("创建者");
        cell = row.createCell(9);
        cell.setCellValue("修改时间");
        cell = row.createCell(10);
        cell.setCellValue("修改者");

        //遍历activityList,创建HSSFRow对象
        if (activityList != null && activityList.size() > 0) {
            Activity activity = null;
            for (int i = 0; i < activityList.size(); i++) {
                activity = activityList.get(i);
                //获取对象
                row=sheet.createRow(i+1);
                cell = row.createCell(0);
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditTime());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditBy());
            }
        }
        //文件下载
        //1.设置响应类型,响应头信息
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=activityList.xls");
        //2.获取输出流
        OutputStream out = response.getOutputStream();
        //直接不用写入磁盘,浏览器直接获取,效率高
        wb.write(out);
        wb.close();
        out.flush();
    }
    @GetMapping("/workbench/activity/queryActivityRemarkByActivityId.do")
    public String queryActivityRemarkByActivityId(String id,HttpServletRequest request){
        //调用service层方法
        Activity activity=activityService.queryActivityForDetail(id);
        List<ActivityRemark> remarkList=activityRemarkService.queryActivityRemarkForDetailByActivityId(id);
        //把数据保存在request中
        request.setAttribute("activity",activity);
        request.setAttribute("remarkList",remarkList);
        //跳转页面,请求转发
        return "workbench/activity/detail";
    }
}
