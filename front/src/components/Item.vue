<template>
    <tr>
        <td>{{ student.number }}</td>
        <td>{{ student.name }}</td>
        <td v-if="isEdited==false">{{ student.age }}</td>
        <td v-if="isEdited==false">{{ student.place }}</td>
        <td v-if="isEdited==false">{{ student.chi }}</td>
        <td v-if="isEdited==false">{{ student.math }}</td>
        <td v-if="isEdited==false">{{ student.eng }}</td>
        <td v-if="isEdited==false">
            <el-button type="primary" icon="el-icon-edit" circle @click='edit'></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete"></el-button>
        </td>
         <td v-if="isEdited==true">
                <el-input type="text" v-model.number="student.age" class="w-50"></el-input>
        </td>
        <td v-if="isEdited==true">
                <el-input type="text" v-model="student.place" class="w-75"></el-input>   
                <!-- <SelectPlace/> -->
        </td>
        <td v-if="isEdited==true">
                <el-input type="text" v-model.number="student.chi" class="w-50"></el-input>
        </td>
        <td v-if="isEdited==true">
                <el-input type="text" v-model.number="student.math" class="w-50"></el-input>
        </td>
        <td v-if="isEdited==true">
                <el-input type="text" v-model.number="student.eng" class="w-50"></el-input>
        </td>
        <td v-if="isEdited==true">
         <el-button type="success" icon="el-icon-check" circle @click="save"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete"></el-button>
        </td>
    </tr>
    
    
</template>

<script>
import axios from 'axios'
// import SelectPlace from "./SelectPlace"
export default {
    name:"Item",
    props:["student"],
    data() {
        return {
            isEdited:false
        }
    },
    components: {
        // SelectPlace
    },
    methods: {
        edit(){
            this.isEdited=true;
            console.log(this.$route.params);
        },
       async save(){
            if (this.student.age>100||this.student.age<0) {
                 this.$alert('年龄不合法！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if (this.student.chi>100||this.student.chi<0) {
                 this.$alert('语文成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if (this.student.math>100||this.student.math<0) {
                 this.$alert('数学成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
            else if (this.student.eng>100||this.student.eng<0) {
                 this.$alert('英语成绩必须0~100之间哦！', '温馨提示', {
                 confirmButtonText: '知道啦',
                });
            }
           else{
                await axios({
                url:"http://localhost:8080/update",
                method:"POST",
                data:this.student
            })
            this.isEdited=false;
            }
        },
        handleDelete(){
           this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          await  axios({
                url:"http://localhost:8080/delete/",
                method: 'POST',
                data:{
                    id:this.student.id
                }
            })
            this.$emit('reloadTable');
            this.$message({
                type: 'success',
                message: '删除成功!'
            });
            }).catch(() => {
            this.$message({
                type: 'info',
                message: '已取消删除'
            });          
            });
        }
    },
}
</script>

<style scoped>
    input{
        height:30px
    }
    td{
        width:60px
    }
</style>