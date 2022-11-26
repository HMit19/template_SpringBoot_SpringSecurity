package com.example.spring_security_boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// Các bước xây dựng entity theo spring boot
// 1. tạo class entity
// 2. tạo các thuộc tính của entity
// @Transient dùng để bỏ qua 1 thuộc tính trong entity, nghĩa là nó sẽ không tạo ra 1 cột trong database
// 3. tạo các getter, setter sử dụng lombok. Gồm các annotation @Getter, @Setter
// 4. tạo constructor sử dụng lombok. Gồm các annotation @NoArgsConstructor, @AllArgsConstructor
// @NoArgsConstructor có nghĩa là tạo ra constructor không tham số
// @AllArgsConstructor có nghĩa là tạo ra constructor có tất cả các tham số
// @Temporal(TemporalType.DATE) có nghĩa là chỉ lấy ngày của thuộc tính dateOfBirth
//  @UniqueConstraint có nghĩa là cột username trong bảng user phải là duy nhất
// @PrePersist có nghĩa là sẽ được gọi trước khi lưu dữ liệu vào database
// @PreUpdate có nghĩa là sẽ được gọi trước khi cập nhật dữ liệu vào database
// columnDefinition có nghĩa là chỉ định kiểu dữ liệu của cột trong database
// collate = "utf8mb4_unicode_ci" dùng để định dạng dữ liệu trong cột là utf8mb4_unicode_ci. Tức là có thể lưu được các ký tự đặc biệt
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
@Table(name = "accounts", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String password;
    @Column(name = "user_role", length = 20)
    private String userRole;
    @Transient
    @Column(columnDefinition = "nvarchar(255)")
    private String confirmPassword;
}