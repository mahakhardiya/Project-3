<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:AfterLogin title="Passport">

<jsp:attribute name="header">
    <style>
        td{
            font-family: emoji;
        }
    </style>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
           <script>
        function printDiv(divName) {
            window.print();
        }
    </script>
    <style>
        @media print {
            @page {
                size: potrait;
            }
        }
    </style>
</jsp:attribute>

<jsp:attribute name="content">
    
    <div class="container" id="contentToDownload" style="display: flex; justify-content: left; margin-top: 5%; width: 450px; text-align: left; border-style: none; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
        <!-- Content of contentToDownload div goes here -->
        <div class="profile">
            <img alt="profile" src="${pageContext.request.contextPath}/images/profile.jpg" width="170px" height="160px" style="border-radius: 100%;margin-top: 13px;box-shadow:solid;">
            <div style="position: relative;margin-top: 20px;">
                <table>
                    <tr>
                        <td><h6><b>Nationality</b>: ${passport.country}</h6></td>
                    </tr>
                    <tr>
                        <td><h6><b>Issue Date</b>: ${passport.issueDate}</h6></td>
                    </tr>
                </table>
            </div>
        </div>
        <div style="height: 250px;padding-left: 10px;">
            <table cellpadding="2px">
                <tr>
                    <td><h5 style="color: #1d3963;padding-left: 42px;" ><img src="${pageContext.request.contextPath}/images/DownloadPassportLogo.png" height="25px" width="110px"></h5></td>
                </tr>
                <tr>
                    <td><h6><b>First Name</b>: ${user.firstName}</h6></td>
                    
                </tr>
                <tr>
                    <td><h6><b>Surname</b>: ${user.surname}</h6></td>
                </tr>
                <tr>
                    <td><h6><b>DOB</b>: ${user.dateOfBirth}</h6></td>
                </tr>
                <tr>
                    <td><h6><b>Passport No</b>: ${passport.passportId}</h6></td>
                </tr>
                <tr>
                    <td><h6><b>Gender</b>: ${user.gender}</h6></td>
                </tr>
                <tr>
                    
                    <td><h6><b>State</b>: ${passport.state}</h6></td>
                </tr>
                <tr>
                    
                    <td><h6><b>Expiry Date</b>: ${passport.expiryDate}</h6></td>
                </tr>
            </table>
        </div>
    </div>
    <div style="position: relative;display: flex;justify-content: center;margin-top: 1%">
        <input type="button" value="Download" style="margin-right: 1%" class="btn btn-danger" onclick="printDiv('contentToDownload')">
    </div>
    
 
</jsp:attribute>

</m:AfterLogin>
