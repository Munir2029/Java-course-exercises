<?php
// ✅ الاتصال بقاعدة البيانات
require "db.php"; // تأكد أن هذا الملف يحتوي على الاتصال بـ $pdo

// ✅ إخبار المتصفح أن المخرجات هي JSON
header('Content-Type:application/json');

// ✅ محاولة جلب البيانات من الجدول
try {
    $dbConnect=connectToDb();
    $stmt = $dbConnect->query("SELECT * FROM customers");
    $customers = $stmt->fetchAll(PDO::FETCH_ASSOC);
  

    echo json_encode($customers); // ✅ إرسال النتيجة بصيغة JSON
} catch (PDOException $e) {
    // إذا حدث خطأ في قاعدة البيانات، نُرسل رسالة خطأ للمستخدم
    http_response_code(500);
    echo json_encode(['error' => $e->getMessage()]);
}
?>
