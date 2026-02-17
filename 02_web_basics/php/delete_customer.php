<?php
// 🟡 1. الاتصال بقاعدة البيانات
require 'db.php';  // تأكد أن db.php فيه دالة connectToDb()

// 🟡 2. التحقق من أن الطلب تم عبر POST وأن id موجود
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['id'])) {
    $id = $_POST['id'];  // نأخذ ID الزبون المُراد حذفه

    try {
        $pdo = connectToDb();  // الاتصال بقاعدة البيانات
        $stmt = $pdo->prepare("DELETE FROM customers WHERE company_id = :id");

        // 🟡 3. تنفيذ الحذف
        $stmt->execute([':id' => $id]);

        // 🟢 4. الرد بناءً على النتيجة
        if ($stmt->rowCount() > 0) {
            echo 'success'; // تم الحذف بنجاح
        } else {
            echo 'not_found'; // لم يتم العثور على الزبون بهذا الـ ID
        }

    } catch (PDOException $e) {
        // 🔴 5. خطأ في قاعدة البيانات
        http_response_code(500); // كود خطأ داخلي
        echo 'error: ' . $e->getMessage();
    }

} else {
    // 🔴 6. إذا كان الطلب غير صحيح (مثلاً GET أو بدون ID)
    http_response_code(400); // Bad request
    echo 'invalid_request';
}
