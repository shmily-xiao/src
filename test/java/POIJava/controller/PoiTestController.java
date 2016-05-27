package POIJava.controller;

import POIJava.Entity.BrandMobileInfoEntity;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by simpletour_java on 2015/9/8.
 */
@Controller
public class PoiTestController {
    @RequestMapping(value = "/importBrandSort", method = RequestMethod.POST)
    public String importBrandSort(@RequestParam("filename") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String temp = request.getSession().getServletContext()
                .getRealPath(File.separator)
                + "temp"; // 临时目录
        File tempFile = new File(temp);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        DiskFileUpload fu = new DiskFileUpload();
        fu.setSizeMax(10 * 1024 * 1024); // 设置允许用户上传文件大小,单位:位
        fu.setSizeThreshold(4096); // 设置最多只允许在内存中存储的数据,单位:位
        fu.setRepositoryPath(temp); // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
        // 开始读取上传信息
        // int index = 0;
        List fileItems = null;
        try {
            fileItems = fu.parseRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
        FileItem fileItem = null;
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息
            if (!item.isFormField()) {
                fileItem = item;
                // index++;
            }
        }

        if (fileItem == null)
            return null;

        if (file == null)
            return null;
//        logger.info(file.getOriginalFilename());

        String name = file.getOriginalFilename();// 获取上传文件名,包括路径
        //name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名
        long size = file.getSize();
        if ((name == null || name.equals("")) && size == 0)
            return null;
        InputStream in = file.getInputStream();
        int count = importBrandPeriodSort(in).size();

        // 改为人工刷新缓存KeyContextManager.clearPeriodCacheData(new
        // PeriodDimensions());// 清理所有缓存
        //int count = BrandMobileInfos.size();
        String strAlertMsg ="";

        strAlertMsg= "成功更新" + count + "条！";

//        logger.info(strAlertMsg);
        //request.setAttribute("brandPeriodSortList", BrandMobileInfos);
        //request.setAttribute("strAlertMsg", strAlertMsg);

        request.getSession().setAttribute("msg",strAlertMsg);
        return "success";
        //return null;
    }
    
    public List<BrandMobileInfoEntity> importBrandPeriodSort(InputStream in) throws Exception  {

        List<BrandMobileInfoEntity> brandMobileInfos = readBrandPeriodSorXls(in);
        for (BrandMobileInfoEntity brandMobileInfo : brandMobileInfos) {
//            mapper.updateByConditions(brandMobileInfo);
        }
        return brandMobileInfos;
    }

    private List<BrandMobileInfoEntity> readBrandPeriodSorXls(InputStream is)
            throws IOException, ParseException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<BrandMobileInfoEntity> brandMobileInfos = new ArrayList<BrandMobileInfoEntity>();
        BrandMobileInfoEntity brandMobileInfo;
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                brandMobileInfo = new BrandMobileInfoEntity();
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
//                    HSSFCell brandIdHSSFCell = hssfRow.getCell(i);
                    if (i == 0) {
                        brandMobileInfo.setName(hssfRow.getCell(0).toString());
                    } else if (i == 1) {
                        brandMobileInfo.setAge(Integer.parseInt(hssfRow.getCell(1).toString()));
                    } else if (i == 2) {
                        brandMobileInfo.setIdNo(hssfRow.getCell(2).toString());
                    } else if (i == 3) {
                        brandMobileInfo.setMobile(hssfRow.getCell(3).toString());
                    }
                }
                brandMobileInfos.add(brandMobileInfo);

            }
        }
        return brandMobileInfos;
    }
}
