<%-- 
    Document   : Indez
    Created on : 22/08/2014, 10:30:51 PM
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserRegister</title>
    </head>
    <body>
        <h1>Registro</h1>
        <section>
            <form action="../Controler" method="POST">
                <table>
                    
                <tr>  
                <td><label>Nombre</label></td> 
                <td><input type="text" name="txtNombre" placeholder="Nombre" required="Requerido"/> </td> 
                </tr>
                
                <tr>
                <td><label>Apellido Paterno</label></td>
                <td><input type="text" name="txtPaterno" placeholder="Apellido Paterno" required="Requerido"/> </td>
                </tr>
                
                <tr>
                <td><label>Apellido Materno</label></td>
                <td><input type="text" name="txtMaterno" placeholder="Apellido Materno" required="Requerido"/></td>
                </tr>
                
                <tr>
                <td><label>E-mail</label></td>
                <td><input type="email" name="txtMail" placeholder="E-mail" required="Requerido"/> </td>
                </tr>
                 
                <tr>
                <td><label>Usuario</label></td>
                <td><input type="text" name="txtUsuario" placeholder="Usuario" required="Requerido"/> </td>
                </tr>
                
                <tr>
                <td><label>Password</label></td>
                <td><input type="password" name="txtPass" placeholder="Password" required="Requerido"/></td>
                </tr>
                
                <tr>
                <td><label>Tipo de usuario</label></td>
                <td><input type="text" name="txtTipo" placeholder="L"/></td>
                </tr>
                
                <tr>
                <td><input type="submit" value="Comenzar"> </td>
                </tr>
                
                </table>
            </form>
        </section>
    </body>
</html>
