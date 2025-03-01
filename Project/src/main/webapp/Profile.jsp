<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee Profile</title>
  <link rel="stylesheet" href="styles.css">
  <style>
  /* General page styling */
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

/* Profile card styling */
.profile-card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 300px;
  padding: 20px;
  text-align: left;
}

.profile-title {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
}

/* Profile details styling */
.profile-details {
  margin-top: 10px;
}

.profile-item {
  margin-bottom: 15px;
}

.profile-item strong {
  color: #555;
}

.profile-info {
  color: #333;
  font-weight: normal;
  display: block;
  margin-top: 5px;
  font-size: 14px;
}

/* Add responsiveness */
@media (max-width: 480px) {
  .profile-card {
    width: 100%;
    padding: 15px;
  }
}
  
  </style>
</head>
<body>
  <div class="profile-card">
    <h2 class="profile-title">Employee Profile</h2>
    <div class="profile-details">
      <div class="profile-item">
        <strong>Employee Name:</strong> <span class="profile-info">${emp_name}</span>
      </div>
      <div class="profile-item">
        <strong>Email:</strong> <span class="profile-info">${email}</span>
      </div>
      <div class="profile-item">
        <strong>Department:</strong> <span class="profile-info">${department}</span>
      </div>
      <div class="profile-item">
        <strong>Role:</strong> <span class="profile-info">${role}</span>
      </div>
    </div>
  </div>
</body>
</html>
