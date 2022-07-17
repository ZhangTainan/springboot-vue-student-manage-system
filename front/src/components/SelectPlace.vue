<template>
<select class="form-select w-100" aria-label="Default select example" @change="handleChange(val)">
  <option selected>选择地区</option>
  <option v-for="pro in selectedOptions" :key="pro" value="pro" @click="handleChange(e)">{{pro}}</option>
</select>
 
</template>
 
<script>
  import { provinceAndCityData } from 'element-china-area-data'
  export default {
    data () {
      return {
        options: provinceAndCityData,
      }
    },
 
    methods: {
      handleChange (e) {
            console.log(e)   
      }
    },
    computed: {
        selectedOptions() {
            // let provinces = []
            // for (let index = 0; index < this.options.length; index++) {
            //     provinces.push(this.options[index].label)
            // }
            // return provinces
            return this.options.map(val=>val.label)
        }
        
    }
    
  }
</script>

<style>

</style>