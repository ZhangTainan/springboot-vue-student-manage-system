<template>
  <div>
     <table class="table caption-top  table-hover">
  <caption>
      <span class="h5 text-dark">学生列表</span>
       <span class="col-4 offset-3">
           <el-input class="w-25" placeholder="请输入学生姓名" v-model="searchName"></el-input>
           <el-button type="primary" icon="el-icon-search" circle class="m-1" @click="searchStudent" v-show="!isSearched"></el-button>
           <el-button type="info" icon="el-icon-refresh-right" circle class="m-1" @click="backBeforeSearch" v-show="isSearched"></el-button>
       </span>
      <span class="col-1">
          <el-button type="warning" icon="el-icon-plus" circle @click="centerDialogVisible = true"></el-button>
          <!-- <el-button type="text" >点击打开 Dialog</el-button> -->

            <el-dialog
            title="添加学生"
            :visible.sync="centerDialogVisible"
            width="35%"
            center>
            <div class="text-center">
                学生学号:
               <el-input v-model="newStudent.number" class="w-50" placeholder="请输入学号"></el-input>
            </div>
            <div class="mt-1 text-center">
                学生姓名:
               <el-input v-model="newStudent.name" class="w-50" placeholder="请输入姓名"></el-input>
            </div>
            <div class="mt-1 text-center">
                学生年龄:
               <el-input v-model.number="newStudent.age" class="w-50" placeholder="请输入年龄" type="text"></el-input>
            </div>
            <div class="mt-1 text-center">
                学生户籍:
               <el-input v-model="newStudent.place" class="w-50" placeholder="请输入学生生源地"></el-input>
            </div>
            <div class="mt-1 text-center">
                语文成绩:
               <el-input v-model.number="newStudent.chi" class="w-50" placeholder="请输入语文成绩" type="text"></el-input>
            </div>
            <div class="mt-1 text-center">
                数学成绩:
               <el-input v-model.number="newStudent.math" class="w-50" placeholder="请输入数学成绩" type="text"></el-input>
            </div>
            <div class="mt-2 text-center">
                英语成绩:
               <el-input v-model.number="newStudent.eng" class="w-50" placeholder="请输入英语成绩" type="text"></el-input>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="centerDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addStudent">添加</el-button>
            </span>
            </el-dialog>
        <!-- <el-button type="warning" icon="el-icon-plus" circle @click="addStudent"></el-button> -->
      </span>
      
  </caption>
  <thead>
    <tr>
      <th scope="col">编号</th>
      <th scope="col">姓名</th>
      <th scope="col">年龄</th>
      <th scope="col">生源地</th>
      <th scope="col">语文</th>
      <th scope="col">数学</th>
      <th scope="col">英语</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
      <Item  v-for="student in students" :key="student.id" :student="student" v-on:reloadTable="updateTable"/>
  </tbody>
</table>
    <el-pagination
      v-show="!isSearched"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[4,5,6]"
      :page-size="5"
      layout="total, sizes, prev, pager, next, jumper"
      :total="count">
    </el-pagination>
        <!-- <el-button-group v-show="!isSearched">
            <el-button type="primary" icon="el-icon-arrow-left" @click="lastPage">上一页</el-button>
            <el-input placeholder="页数"></el-input>
            <el-button type="primary" @click="nextPage">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
        </el-button-group> -->
    <VNode/>
  </div>
</template>

<script>
import axios from 'axios'
import Item from "./Item"
// import VNode from "./VNode"
export default {
    name:'table',
    data() {
        return {
            centerDialogVisible: false,
            students:[],
            page:1,
            count: 0,
            number_per_page:5,
            newStudent:{
                number:"", name:"", age:"", place:"",chi:"", math:"", eng:"",
            },
            searchName: "",
            
            isSearched:false,
        }
    },
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.number_per_page = val;
            axios({
              url: "http://localhost:8080/students",
              method: "POST", 
              data: {
                  page: this.page,
                  number_per_page: this.number_per_page
              }
            }).then(res => {
            this.students=res.data
           })
      },
      handleCurrentChange(val) {
          console.log(`当前页: ${val}`);
          this.page = val
          axios({
              url: "http://localhost:8080/students",
              method: "POST", 
              data: {
                  page: this.page,
                  number_per_page: this.number_per_page
              }
          }).then(res => {
            this.students=res.data
           })

      },
        nextPage() {
            if(this.page*5>=this.count){
                 this.$alert('没有下一页啦', '温馨提示', {
                confirmButtonText: '知道啦',
                });
            }
            else{
                this.page+=1;
                axios.get('http://localhost:8080/students/'+this.page).then(
                    response => {
                        this.students=response.data;
                    },
                    error =>{
                        console.log(error.massage);
                    }
                )
            }
            
        },
        lastPage(){
            if(this.page===1){
                this.$alert('这已经是第一页啦', '温馨提示', {
                confirmButtonText: '知道啦',
                });
            }
            else{
                this.page-=1;
                axios.get('http://localhost:8080/students/'+this.page).then(
                response => {
                    this.students=response.data;
                },
                error =>{
                    console.log(error.massage);
                }
            )
            }
        },
      async  addStudent(){
            if (this.newStudent.number==""||this.newStudent.name==""||this.newStudent.age===""||this.newStudent.chi===""||this.newStudent.math==="" || this.newStudent.eng==="") {
                this.$alert('所有内容均不可为空哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if (this.newStudent.age<=0 || this.newStudent.age>150) {
                 this.$alert('年龄太大或太小本班级不收哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if(this.newStudent.chi<0 || this.newStudent.chi>100){
                this.$alert('语文成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if(this.newStudent.math<0 || this.newStudent.math>100){
                this.$alert('数学成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }else if(this.newStudent.eng<0 || this.newStudent.eng>100){
                this.$alert('英语成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            } 
            else{
               await axios({
                    url:"http://localhost:8080/add/",
                    method:"POST",
                    data:this.newStudent
                });
                this.$message({
                type: 'success',
                message: '添加成功!'
            });
                this.centerDialogVisible=false;
             await  axios.get('http://localhost:8080/get_students_count/').then(
             response => {
                    this.count=parseInt(response.data);
                },
                error =>{
                    console.log(error.massage);
                })
               await this.updateTable();
            }
        },
        searchStudent(){
            
            // alert('http://localhost:8080/search?name='+this.searchName+"&")
            if (this.searchName==="") {
                this.$alert("查询内容不能为空！","温馨提示",{
                    confirmButtonText: '知道啦'
                })
            }
            else{
                axios({
                    url:"http://localhost:8080/search",
                    method:"POST",
                    data:{
                        name:this.searchName,
                    }
                }).then(
                    response => {
                        console.log(response.data);
                        // this.students=response.data.students;
                        this.students=response.data;
                        // alert(this.count);
                    },
                    error =>{
                        console.log(error.massage);
                    }
                )
                
                this.isSearched=true;
            }
        },
       backBeforeSearch(){
            this.searchName=""
            // axios.get('http://localhost:8080/students/'+this.page).then(
            //     response => {
            //         console.log(response.data);
            //         // this.students=response.data.students;
            //         this.students=response.data;
            //     },
            //     error =>{
            //         console.log(error.massage);
            //     }
            // );
            this.updateTable()
            this.isSearched=false;
        },
      async  updateTable() {
            // alert("表格更新")
          axios({
              url: "http://localhost:8080/students",
              method: "POST", 
              data: {
                  page: this.page,
                  number_per_page: this.number_per_page
              }
        }).then(res => {
            this.students=res.data;
           })
        axios.get('http://localhost:8080/get_students_count/').then(
             response => {
                    this.count=parseInt(response.data);
                },
                error =>{
                    console.log(error.massage);
                }
        )
        },

    },
    components:{
        Item
    },
    mounted() {
        axios({
              url: "http://localhost:8080/students",
              method: "POST", 
              data: {
                  page: this.page,
                  number_per_page: this.number_per_page
              }
        }).then(res => {
            this.students=res.data;
           })
        axios.get('http://localhost:8080/get_students_count/').then(
             response => {
                    this.count=parseInt(response.data);
                },
                error =>{
                    console.log(error.massage);
                }
        )
    },
   async beforeRouteEnter (to, from, next) {
       if(sessionStorage.getItem('token')==null){
            alert("您还没有登录，请先登录！")
       }else{
            await axios({
                url: "http://localhost:8080/checkToken",
                method: "POST",
                data: {
                    username: sessionStorage.getItem('username'),
                    token: sessionStorage.getItem('token')
                }
            }).then(res => {
                if (res.data=="1") {
                    next()
                }
                else{
                    alert("登录信息已过期！请重新登录")
                    location.reload();
                }
            })
       }
       
        // next()
    }
    

}
</script>

<style scoped>

</style>