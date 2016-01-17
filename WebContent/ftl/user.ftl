<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <#include "common-js.ftl"/>
    <#include "page.ftl"/>
    <#include "checkbox.ftl"/>
    <script>
    $(document).ready(function(){
		page();
	})
    	<#--根据id查询用户信息-->
      	function updateUser(userid){
      		$.ajax({
      			type:"post",
      			url:"queryUserById.do",
      			data:{id:userid},
      			dataType:"json",
      			success:function(data){
      				$('#id').val(data.id);
      				$('#username').val(data.name);
      				$('#password').val(data.pwd);
      				if(data.auth==1){
      					$('#userAuth')[0].selectedIndex = 1;
      				}else{
      					$('#userAuth')[0].selectedIndex = 0;
      				}
      				$('#updateUser').modal();
      			},
      			error : function() {  
		              alert("异常！");
		        }
      		}
      		);
      	}
      	<#--deleteUsers-->
			function go() {
            var str="";
            $("input[id='subcheck']:checkbox").each(function(){ 
                if($(this).attr("checked")){
                    str += $(this).val()+","
                }
            });
            <#--alert(str);-->
            $.post("deleteUsers.do",
            {idList:str},
            function(){
            window.location.reload();
            }
            );
            <#--$.ajax({
            	type:"post",
      			url:"deleteUsers.do",
      			data:{idList:str},
      			dataType:"json",
      			success:function(data){
      				$.post("userManage.do");   
      			},
      			error:function(data){
      			}
            });-->
            
        } 	
        function test(){
        	$.post("queryUserByPage.do",
        	{
        		currentPage:2,
        		pageSize:10
        	})
        }
      </script>
  </head>
  <body>

    <#include "head.ftl"/>
    <#include "functionList.ftl"/>
      <div class="span9">
        <div>
          <table class="table table-hover" >
            <tr>
              <td align="center">用户名</td>
              <td align="center"><input type="text" name="name"></td>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="utype">
                  <option >普通用户</option><option >管理员</option>
                </select>
              </td>
              <td><input type="button" class="btn btn-success" value="查询" onclick="test()"></td>
            </tr>
            
          </table>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加用户</a>
          <input type="button" class="btn btn-warning" value="删除用户" onclick="go()">
        </div>
        <br>
        <div>
          <table class="table" >
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox" id="SelectAll" onclick="selectAll()"><font color="white">全选</font></td>
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">用户名</font></td>
              <td align="center"><font color="white">类型</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
            <#list userDo as user>
            <#--这是一段注释-->
      		<tr>
      			<td><input type="checkbox" id="subcheck" onclick="setSelectAll()" value=${user.id}></td>
        		<td>${user.id}</td>
        		<td>${user.name}</td>
        		<td><#if user.auth = 1>管理员</#if><#if user.auth = 2>普通用户</#if></td>
        		<td><button class="btn btn-info" data-toggle="modal" onclick="updateUser(${user.id})">更新</button></td>
      		</tr>
      		</#list>
          </table> 
        </div>
        <div class="pagination pagination-centered" >
          <ul id="page">
          </ul>
        </div>
      </div>
    </div>



    <!-- modal -->
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">增加用户</h3>
      </div>
      <div class="modal-body">
      <form action="addUser.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">用户名</td>
              <td align="center"><input type="text" name="name"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="auth">
                  <option value=2>普通用户</option>
                  <option value=1>管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" name="pwd"></td>
            </tr>
            <tr>
              <td colspan="2"><button class="btn btn-success" type="submit">新增</button></td>
            </tr>
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
    </div>

    <!-- update -->
    <div id="updateUser" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="myModalLabel">更新用户</h3>
      </div>
      <div class="modal-body">
      <form action="updateUser.do" method="post">
        <table class="table table-hover" >
            <tr>
              <input type="hidden" id="id" name="id">
              <td align="center">有户名</td>
              <td align="center"><input type="text" id="username" name="name"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select id="userAuth" name="auth">
                  <option value=2>普通用户</option><option value=1>管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" id="password" name="pwd"></td>
            </tr>  
            <tr>
              <td colspan="2"><button class="btn btn-success" type="submit">更新</button></td>
            </tr>
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
      
  </body>
</html>