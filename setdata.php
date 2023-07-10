<?php

$id = $_POST["id"];
$name = $_POST["name"];
$location = $_POST["address"];

// Database connection details.
$server = "localhost";
$username = "root";
$password = "";
$database = "userdatabase";

// Create a new MySQLi object.
$conn = new mysqli($server, $username, $password, $database);

// Check for connection errors.
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO studentdetails(id,name,address) VALUES('$id', '$name', '$location')";

$result = $conn->query($sql);

if($result)
    echo"Data inserted successfully";
else
    echo"Failed to insert data";

// Close the database connection.
$conn->close();
?>