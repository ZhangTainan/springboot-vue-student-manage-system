<template>
  <div>
    <div style="margin: 40px;"></div>
    <el-col span="10" offset="7" class="border-secondary border border-5 bg-light">

      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm mt-5">
      <el-form-item label="用户名" prop="username">
      <el-input v-model="ruleForm.username" placeholder="请输入用户名" class="w-75"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="pass">
      <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="请输入密码" class="w-75"></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="checkPass">
      <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="请再次输入密码" class="w-75"></el-input>
    </el-form-item>
    
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
      <!-- <div style="margin: 80px;"></div> -->
  </el-form>
    </el-col>
  </div>
</template>

<script>
import md5 from "js-md5"
import axios from 'axios';

 export default {
   name:"Login",
    data() {
      var checkusername = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('用户名不能为空'));
        }
        // setTimeout(() => {
            if (value.length >18 || value.length<6) {
              callback(new Error('用户名长度必须在6-18位之间'));
            } else {
              callback();
            
          }
        // }, 10);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          username: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          username: [
            { validator: checkusername, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios({
              url: "http://localhost:8080/register",
              method: "POST",
              data:{
                username:this.ruleForm.username,
                password:md5(this.ruleForm.pass)
              }
            }).then(res=>{
              sessionStorage.setItem("username",res.data.username);
              sessionStorage.setItem("token",res.data.token);
            })
            this.$alert("注册成功快去登录吧！","温馨提示",{
                    confirmButtonText: '知道啦'
                })
            this.$router.push({
              name:"login"
            })
          } else {
            console.$alert('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style>

</style>