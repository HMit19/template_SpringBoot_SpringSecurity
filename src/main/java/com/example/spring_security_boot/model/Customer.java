package com.example.spring_security_boot.model;

import lombok.*;

import javax.persistence.*;


// Các bước để tạo ra một Entity trong JPA
// 1. Tạo 1 class dùng để đại diện cho bảng trong database
// 2. Tạo 1 constructor không tham số dùng để khởi tạo giá trị mặc định
// 3. Tạo 1 constructor dùng để khởi tạo giá trị cho các thuộc tính của class
// 4. Tạo 1 getter va setter có tác dụng để lấy và gán giá trị cho các thuộc tính của class
// 5. Tạo 1 annotation @Entity để báo cho spring boot biết đây là 1 entity
// 6. Tạo 1 annotation @Table có tác dụng để đặt tên cho bảng trong database
// 7. Tạo 1 annotation @Id dùng để đánh dấu thuộc tính nào là khóa chính
// 8. Tạo 1 annotation @GeneratedValue dùng để tạo ra 1 giá trị tự động cho id
// 9. Tạo 1 annotation @Column dùng để tạo ra 1 cột trong database
// 10. Tạo 1 annotation @OneToMany dùng để tạo ra 1 quan hệ 1-n với bảng khác
// mappedBy dùng để đặt tên cho thuộc tính trong bảng khác mà nó quan hệ với bảng này
// 11. Tạo 1 annotation @ManyToOne dùng để tạo ra 1 quan hệ n-1 với bảng khác
// 12. Tạo 1 annotation @ManyToMany dùng để tạo ra 1 quan hệ n-n với bảng khác
// 13. Tạo 1 annotation @OneToOne dùng để tạo ra 1 quan hệ 1-1 với bảng khác
// 14. Tạo 1 annotation @JoinColumn có tác dụng tạo ra 1 cột trong database để tham chiếu đến khóa chính của bảng khác
// 15. Tạo 1 annotation @JoinTable có tác dụng tạo ra 1 bảng trung gian để tham chiếu đến khóa chính của bảng khác
// 16. Tạo 1 annotation @Transient dùng để bỏ qua 1 thuộc tính trong entity, nghĩa là nó sẽ không tạo ra 1 cột trong database
// 17. Tạo 1 annotation @Embeddable dùng để tạo ra 1 class có thể được nhúng vào 1 class khác
// 18. Tạo 1 annotation @Embedded dùng để nhúng 1 class vào 1 class khác

// Các bước xây dựng entity theo spring boot
// 1. tạo class entity
// 2. tạo các thuộc tính của entity
// 3. tạo các getter, setter sử dụng lombok. Gồm các annotation @Getter, @Setter
// 4. tạo constructor sử dụng lombok. Gồm các annotation @NoArgsConstructor, @AllArgsConstructor
// @NoArgsConstructor có nghĩa là tạo ra constructor không tham số
// @AllArgsConstructor có nghĩa là tạo ra constructor có tất cả các tham số
// @Data có nghĩa là tạo ra các annotation @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
// 5. tạo toString
// 6. tạo các annotation
// 7. tạo các annotation để mapping với các bảng trong database
// 8. tạo các annotation để mapping với các cột trong database
// ví dụ: @Column(name = "id") có nghĩa là mapping với cột id trong database với tên id trong entity.
// Tên thuộc tính của entity có thể khác với tên cột trong database. Để chúng hiểu thì ta phải mapping với nhau.
// Ví dụ: @Column(name = "customer_id") có nghĩa là mapping với cột customer_id trong database với tên id trong entity.
// nhưng nếu tên thuộc tính của entity giống với tên cột trong database thì không cần phải khai báo @Column
// 9. tạo các annotation để mapping với các khóa ngoại trong database
// ví dụ: @ManyToOne, @OneToMany, @OneToOne, @ManyToMany
// 10. tạo các annotation để mapping với các khóa chính trong database
// Ví dụ: @Id, @GeneratedValue
// 11. tạo các annotation để mapping với các khóa chính tự tăng trong database
// Ví dụ: @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)

@Entity
@Table(name = "customers")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
