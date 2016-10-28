import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simpletour_Jenkin on 2016/10/12.
 */
public class freemarker extends HttpServlet {
        static final long serialVersionUID = 1L;
        private Configuration cfg;
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doPost(request,response);
        }

        public void init() throws ServletException {
            super.init();
            cfg = new Configuration();
            cfg.setClassicCompatible(true);
            cfg.setServletContextForTemplateLoading(getServletContext(),"WEB-INF/templates");
            //cfg.setClassicCompatible(true);//处理空值为空字符串

        }
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            System.out.println(this.getServletContext().getContextPath()+"/WEB-INF/templates");
            response.setCharacterEncoding("gbk");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Map<String,Object> root = new HashMap<String,Object>();
            root.put("one", "zs");
            root.put("two", "ls");
            root.put("three", "ww");
            root.put("fore", "zl");

            Template template = cfg.getTemplate("test.ftl");
            response.setContentType("text/html;charset=gbk");//设定字符集，否则有汉字乱码
            try {
                //1.用Enviroment
                Environment env = template.createProcessingEnvironment(root, out);
                env.setClassicCompatible(true);
                env.process();
                //2.template.process(root, out);//两种方法都可以

            } catch (TemplateException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        }

    }

