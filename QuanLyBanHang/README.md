# Hệ thống Quản lý Bán hàng Siêu thị

Ứng dụng Java Swing quản lý bán hàng trong siêu thị với đầy đủ các tính năng theo yêu cầu.

## Cấu trúc dự án

```
QuanLyBanHang/
├── src/
│   ├── Main.java                      # Điểm khởi chạy ứng dụng
│   ├── model/                         # Các lớp Model (Entity)
│   │   ├── MatHang.java              # Lớp mặt hàng
│   │   ├── KhachHang.java            # Lớp khách hàng
│   │   └── ChiTietMuaHang.java       # Lớp chi tiết mua hàng
│   ├── dao/                          # Các lớp DAO (Data Access Object)
│   │   ├── MatHangDAO.java           # Xử lý file MH.TXT
│   │   ├── KhachHangDAO.java         # Xử lý file KH.TXT
│   │   └── QuanLyBanHangDAO.java     # Xử lý file QLBH.TXT
│   └── gui/                          # Các lớp giao diện
│       ├── MainFrame.java            # Cửa sổ chính
│       ├── MatHangPanel.java         # Panel quản lý mặt hàng
│       ├── KhachHangPanel.java       # Panel quản lý khách hàng
│       ├── QuanLyBanHangPanel.java   # Panel quản lý bán hàng
│       └── HoaDonPanel.java          # Panel xem hóa đơn
├── MH.TXT                            # File lưu dữ liệu mặt hàng
├── KH.TXT                            # File lưu dữ liệu khách hàng
└── QLBH.TXT                          # File lưu dữ liệu mua hàng
```

## Mô tả các lớp

### 1. Package Model (model/)

**MatHang.java**
- Thuộc tính: maHang (4 chữ số, tự động tăng), tenHang, nhomHang, giaBan
- Nhóm hàng: Hàng thời trang, Hàng tiêu dùng, Hàng điện máy, Hàng gia dụng
- Validation đầy đủ với exception handling

**KhachHang.java**
- Thuộc tính: maKH (5 chữ số, tự động tăng), hoTen, diaChi, soDT
- Validation đầy đủ với exception handling

**ChiTietMuaHang.java**
- Thuộc tính: maKH, maHang, soLuong
- Thuộc tính phụ để hiển thị: tenKH, tenHang, giaBan
- Tính toán thành tiền tự động

### 2. Package DAO (dao/)

**MatHangDAO.java**
- docFile(): Đọc danh sách mặt hàng từ MH.TXT
- ghiFile(): Ghi danh sách mặt hàng vào MH.TXT
- themMatHang(): Thêm mặt hàng mới
- timTheoMa(): Tìm mặt hàng theo mã

**KhachHangDAO.java**
- docFile(): Đọc danh sách khách hàng từ KH.TXT
- ghiFile(): Ghi danh sách khách hàng vào KH.TXT
- themKhachHang(): Thêm khách hàng mới
- timTheoMa(): Tìm khách hàng theo mã

**QuanLyBanHangDAO.java**
- docFile(): Đọc danh sách mua hàng từ QLBH.TXT
- ghiFile(): Ghi danh sách mua hàng vào QLBH.TXT
- themChiTiet(): Thêm chi tiết mua hàng (kiểm tra không trùng)
- sapXepTheoTenKH(): Sắp xếp theo tên khách hàng
- sapXepTheoTenMatHang(): Sắp xếp theo tên mặt hàng
- layDanhSachTheoKH(): Lấy danh sách mua hàng của một khách hàng

### 3. Package GUI (gui/)

**MainFrame.java**
- Cửa sổ chính với JTabbedPane
- Menu bar với các chức năng hệ thống

**MatHangPanel.java**
- Nhập và hiển thị danh sách mặt hàng
- ComboBox chọn nhóm hàng
- Validation đầy đủ

**KhachHangPanel.java**
- Nhập và hiển thị danh sách khách hàng
- Validation đầy đủ

**QuanLyBanHangPanel.java**
- Lập danh sách mua hàng
- ComboBox chọn khách hàng và mặt hàng
- Sắp xếp theo khách hàng hoặc mặt hàng
- Kiểm tra không cho phép trùng

**HoaDonPanel.java**
- Xem hóa đơn chi tiết theo khách hàng
- Tính tổng tiền tự động

## Tính năng

✅ Nhập thêm mặt hàng mới vào file MH.TXT với xử lý ngoại lệ
✅ Hiển thị danh sách mặt hàng dạng bảng
✅ Nhập thêm khách hàng vào file KH.TXT với xử lý ngoại lệ
✅ Hiển thị danh sách khách hàng dạng bảng
✅ Lập danh sách mua hàng, lưu vào QLBH.TXT
✅ Kiểm tra không cho phép một khách hàng mua cùng một mặt hàng 2 lần
✅ Sắp xếp danh sách mua hàng theo tên khách hàng
✅ Sắp xếp danh sách mua hàng theo tên mặt hàng
✅ Lập hóa đơn chi tiết cho mỗi khách hàng
✅ Giao diện Java Swing đầy đủ
✅ Sử dụng ComboBox cho các lựa chọn
✅ Xử lý ngoại lệ đầy đủ: bỏ trống, sai định dạng, giá trị âm

## Cách chạy ứng dụng

### Biên dịch:
```bash
javac -d bin -sourcepath src src/Main.java
```

### Chạy:
```bash
java -cp bin Main
```

### Hoặc sử dụng IDE (Eclipse, IntelliJ IDEA, NetBeans):
1. Import project
2. Chạy Main.java

## Định dạng file

**MH.TXT**: maHang|tenHang|nhomHang|giaBan
```
1001|Áo thun|Hàng thời trang|150000.00
1002|Gạo ST25|Hàng tiêu dùng|25000.00
```

**KH.TXT**: maKH|hoTen|diaChi|soDT
```
10001|Nguyễn Văn A|Hà Nội|0123456789
10002|Trần Thị B|TP.HCM|0987654321
```

**QLBH.TXT**: maKH|maHang|soLuong
```
10001|1001|2
10001|1002|5
```

## Xử lý ngoại lệ

- Bỏ trống: Kiểm tra tất cả các trường không được để trống
- Sai định dạng: Kiểm tra số điện thoại chỉ chứa số, giá bán và số lượng phải là số
- Giá trị âm: Kiểm tra giá bán và số lượng phải >= 0
- Trùng lặp: Không cho phép một khách hàng mua cùng một mặt hàng 2 lần
- Lỗi file I/O: Bắt và hiển thị thông báo lỗi

## Nguyên tắc OOP áp dụng

1. **Encapsulation**: Tất cả thuộc tính đều private, truy cập qua getter/setter
2. **Separation of Concerns**: Tách biệt Model, DAO, GUI
3. **Single Responsibility**: Mỗi lớp có một trách nhiệm rõ ràng
4. **Data Validation**: Validation trong setter methods
5. **Exception Handling**: Xử lý ngoại lệ đầy đủ ở mọi tầng

## Tác giả

Lê Duy Anh - B23DCCN026
