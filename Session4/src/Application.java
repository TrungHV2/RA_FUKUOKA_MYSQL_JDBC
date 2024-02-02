import com.ra.entity.Category;
import com.ra.repository.IRepository;
import com.ra.repository.impl.CategoryRepository;
import com.ra.service.CategoryService;
import com.ra.service.impl.CategoryServiceImpl;
import com.ra.util.MySQLConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryServiceImpl();
        IRepository<Category, Integer> repository = new CategoryRepository();
//        Connection conn = MySQLConnect.open();
//        if (conn != null)
//            System.out.println("SUCCESS");
//        else
//            System.out.println("FAILED");
        //for (Category c : categoryService.findByName("h")) {
        Category category = new Category();
        category.setName("Test Repository 4");
        category.setKeyword("test,new,jdbc");
        category.setDescription("None");
        category.setStatus(false);
        repository.add(category);
        System.out.println("New id: " + category.getId());
        for (Category c : repository.findAll()) {
            System.out.println(c.getId() + ": " + c.getName() + " " + c.isStatus());
        }
        System.out.println("Tìm kiếm theo id");
        Category cat = categoryService.findId(4);
        if (category != null)
            System.out.println("Tên danh mục: " + cat.getName());
        /* BTVN
        Viết các hàm còn lại (update, delete, findId) và CategoryService.
        Tạo menu thêm, sửa, xóa, hiển thị trong hàm main và thực hiện các chức năng này.
        * */
    }
}
