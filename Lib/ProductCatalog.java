package Lib;
import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList ;

/**
 * คลาสทำหน้าที่เป็นแคตตาล็อกสินค้า (Repository)
 */
public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    // RI: products list is not null, contains no null elements, and no duplicate products.
    // AF: AF(products) = A catalog of all available products.

    private void checkRep() {
        if (products == null) {
            throw new RuntimeException("RI violated: products list cannot be null.");
        }
        // Check for duplicate products
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).equals(products.get(j))) {
                    throw new RuntimeException("RI violated: catalog contains duplicate products.");
                }
            }
        }
    }

    public ProductCatalog() {
        checkRep();
    }

    /**
     * เพิ่มสินค้าใหม่เข้าสู่แคตตาล็อก
     * @param product สินค้าที่ต้องการเพิ่ม
     */
    public void addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
        checkRep();
    }

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productId รหัสสินค้าที่ต้องการค้นหา
     * @return อ็อบเจกต์ Product หากพบ, หรือ null หากไม่พบ
     * @throws ProductNotFoundExeption หากไม่พบสินค้า
     */
    public Product findById(String productId) throws ProductNotFoundExeption{
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        // แทนที่จะคีนค่า null , ให้โยน Exeption
        throw new ProductNotFoundExeption("Product with ID "+ productId + " not found in catalog.");
    }
}
