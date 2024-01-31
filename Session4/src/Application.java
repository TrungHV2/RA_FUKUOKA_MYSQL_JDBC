import com.ra.entity.Category;
import com.ra.service.CategoryService;
import com.ra.service.impl.CategoryServiceImpl;
import com.ra.util.MySQLConnect;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
//        Connection conn = MySQLConnect.open();
//        if (conn != null)
//            System.out.println("SUCCESS");
//        else
//            System.out.println("FAILED");
        //for (Category c : categoryService.findByName("h")) {
        Category category = new Category();
        category.setName("Test 1");
        category.setKeyword("test,new,jdbc");
        category.setDescription("None");
        category.setStatus(false);
        categoryService.insert(category);
        System.out.println("New id: " + category.getId());
        for (Category c : categoryService.findAll()) {
            System.out.println(c.getId() + ": " + c.getName() + " " + c.isStatus());
        }
        /* BTVN
        Viết các hàm còn lại (update, delete, findId) và CategoryService.
        Tạo menu thêm, sửa, xóa, hiển thị trong hàm main và thực hiện các chức năng này.
        * */
    }
}
