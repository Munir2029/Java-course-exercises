// ✅ دالة لجلب العملاء من السيرفر باستخدام try...catch
async function getAllCustomers() {
  try {
    const response = await fetch('http://localhost/php2/php-2-Munir2029/get_customers.php'); // إرسال طلب إلى السيرفر

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const customers = await response.json(); // تحويل الاستجابة إلى JSON
    return customers;

  } catch (error) {
    console.error('There was a problem with the fetch operation:', error);
    return null; // يمكن إرجاع [] بدلًا من null حسب احتياجك
  }
}



function refreshAllCustomers() {
  getAllCustomers().then(customers => {
    if (customers) {
      const allCompanies = document.getElementById('allCompaniesContainer');
      allCompanies.innerHTML = ''; // Clear any existing content

      customers.forEach(company => {
        const customerElement = document.createElement('div');
        customerElement.className = 'row col-12 company';
        customerElement.setAttribute('data-id', company.company_id);
        customerElement.setAttribute('data-createdBy', company.created_by);
        customerElement.innerHTML = `
                                                  <div class="col-1 companyId CompanyDetails">${company.company_id}</div>
                              <div class="col-1 CompanyName CompanyDetails">${company.company_name}</div>
                              <div class="col-2 contactPersonPhone CompanyDetails">${company.contact_person_phone}</div>
                              <div class="col-2 Adresse">${company.Adresse}</div>
                              <div class="col-1 createdBy">${company.created_by}</div>
                              <div class="col-1 createdAt">${company.created_at}</div>
                              <div class="col-1 editedAt">${company.edited_at}</div>
                              <div class="col-3 bearbeitenButtons">
                                <button class="btn btn-warning btn-sm bearbeitenBtn">Bearbeiten</button>
                                <button class="btn btn-danger btn-sm löschenBtn">Löschen</button>
                              </div>

                                <div class="editFormContainer" style="display: none; margin-top: 10px; width: 100%;">
                                <input type="text" class="form-control mb-2 editName" value="${company.company_name}">
                                <input type="text" class="form-control mb-2 editPhone" value="${company.contact_person_phone}">
                                <input type="text" class="form-control mb-2 editAdresse" value="${company.Adresse}">
                                <button class="btn btn-success btn-sm saveEditBtn">Save</button>
                                <button class="btn btn-secondary btn-sm cancelEditBtn">Cancel</button>
                              </div>
                                         `;
        allCompaniesContainer.appendChild(customerElement);
      });
    }
  });
}

document.getElementById('akt').addEventListener('click', refreshAllCustomers);


document.getElementById('allCompaniesContainer').addEventListener('click', function (event) {
  if (event.target.classList.contains('löschenBtn')) {
    löschen(event);
  }
});






async function löschen(event) {
  // event.preventDefault();
  const button = event.target;

  // 🔍 نبحث عن العنصر الأب الذي يمثل الشركة
  const parentElement = button.closest('.company');

  if (!parentElement) return;

  // 🆔 جلب المعرف من الخاصية data-id
  const companyId = parentElement.getAttribute('data-id');

  // ⚠️ إظهار تأكيد الحذف
  const confirmed = window.confirm('Sind Sie sicher, dass Sie es löschen wollen?');
  if (!confirmed) return;

  try {
    // 🟡 إرسال طلب حذف إلى السيرفر
    const response = await fetch('delete_customer.php', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `id=${companyId}`
    });

    const result = await response.text();

    if (result.trim() === 'success') {
      // ✅ حذف من الصفحة
      parentElement.remove();
    } else {
      alert('Fehler beim Löschen aus der Datenbank.');
    }
  } catch (error) {
    console.error('Fehler bei der Anfrage:', error);
    alert('Ein Fehler ist aufgetreten.');
  }
}


//  document.getElementById('löschenBtn').addEventListener('click', löschen);

//     // ✅ عند الضغط على الزر شغل الدالة



document.addEventListener('click', function (event) {

  if (event.target.classList.contains('bearbeitenBtn')) {
    const parent = event.target.closest('.company');
    const form = parent.querySelector('.editFormContainer');
    const createdBy = parent.getAttribute('data-createdBy');


    if (createdBy === currentUser) {

      if (form) {
        form.style.display = 'block'; // أظهر النموذج
      }

    } else {
      alert(` Du bist nicht der Ersteller dieses Eintrags. Eingeloggt als: ${currentUser}`)
    }

  }
  // عند الضغط على "Cancel"
  if (event.target.classList.contains('cancelEditBtn')) {
    const parent = event.target.closest('.company');
    const form = parent.querySelector('.editFormContainer');
    if (form) {
      form.style.display = 'none';
    }
  }

  // عند الضغط على "Save"
  if (event.target.classList.contains('saveEditBtn')) {
    const parent = document.querySelector('.company');
    const companyId = parent.getAttribute('data-id');
    const newName = parent.querySelector('.editName').value;
    const newPhone = parent.querySelector('.editPhone').value;
    const newAdresse = parent.querySelector('.editAdresse').value;
 

    // استدعاء دالة التحديث
    updateCompany(companyId, newName, newPhone, newAdresse, currentUser, parent);
  }




});







async function updateCompany(id, name, phone, adresse, currentUser, parentElement) {
  try {
    const response = await fetch('update_customer.php', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `id=${encodeURIComponent(id)}&name=${encodeURIComponent(name)}&phone=${encodeURIComponent(phone)}&adresse=${encodeURIComponent(adresse)}&currentUser=${encodeURIComponent(currentUser)}`
    });

    const result = await response.text();

    if (result.trim() === 'success') {
      alert('update is success');

      const form = parentElement.querySelector('.editFormContainer');
      if (form) form.style.display = 'none';

      parentElement.querySelector('.CompanyName').textContent = name;
      parentElement.querySelector('.contactPersonPhone').textContent = phone;
      parentElement.querySelector('.Adresse').textContent = adresse;

    } else if (result.trim() === 'no_change') {
      alert('Es wurden keine Daten geändert (vielleicht haben Sie dieselben Werte eingegeben.');

      //  نفس الخطوات في حالة success(اختياري)
      const form = parentElement.querySelector('.editFormContainer');
      if (form) form.style.display = 'none';
    }
    else {
      alert('Aktualisierung fehlgeschlagen');
    }


  } catch (error) {
    console.error('Aktualisierung fehlgeschlagen', error);
    alert('Aktualisierung fehlgeschlagen');
  }
}

refreshAllCustomers();
