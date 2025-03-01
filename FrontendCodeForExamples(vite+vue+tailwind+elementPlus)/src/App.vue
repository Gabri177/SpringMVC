<template>
  <!-- <div class="common-layout"> -->
    <el-container class="bg-gray-200 mx-3 mt-3 h-full" style="height: 100vh;">
      <el-header class="flex justify-between items-center">
        <div class="mb-4 mt-5">
          <el-button type="success" @click="addEvent">Add</el-button>

        </div>
        <div>
          <el-input
            v-model="inputSearch"
            style="width: 240px"
            placeholder="Please Input"
            :suffix-icon="Search"
          />
          <el-button @click="handleSearch" class="block ml-3">查找</el-button>
        </div>
        
      </el-header>
      <el-main >
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="id" label="User Id" />
          <el-table-column prop="username" label="User Name" />
          <el-table-column prop="nickname" label="Nick Name" />
          <el-table-column prop="createdate" label="Create Date" />
          <el-table-column label="Operation">
            <template #default="scope">
              <el-button type="primary" @click="editEvent(scope.row, $event)">编辑</el-button>
              <el-button type="danger" @click="deleteEvent(scope.row.id, $event)">删除</el-button>
            </template>
          </el-table-column>

        </el-table>
      </el-main>
    </el-container>
  <!-- </div> -->

  <el-dialog v-model="dialogVisible" title="Tips" width="500" :before-close="handleClose">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <div class="w-full">
        <el-form-item label="User Name" class="w-full">
          <el-input v-model="formInline.username" placeholder="required" clearable />
        </el-form-item>
        <el-form-item label="Nick Name" class="w-full">
          <el-input v-model="formInline.nickname" placeholder="required" clearable />
        </el-form-item>
      </div>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="handleCancle">取消</el-button>
        <el-button type="primary" @click="handleConfirm">
          确认
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>



<script setup>
import { ref, reactive } from 'vue'
import {
  addUser,
  getUserById,
  getAllUser,
  updateUser,
  removeUser,
  getUserByName

} from './api/BasicCrud'
const tableData = ref([]);
const dialogVisible = ref(false);
const inputSearch = ref('');
let   EditTrigger = false;

const formInline = reactive({
  id: '',
  username: '',
  nickname: '',
  createdate: '',
})

const initInfo = () => {
    getAllUser()
    .then(res => {
      console.log('res', res)
      res.data.forEach(item => {
        item.createdate = new Date(item.createdate).toLocaleDateString()
      })
      tableData.value = res.data
    })
    .catch(err => {
      console.log('err', err)
    })
}
initInfo()

const handleSearch = () => {
  getUserByName(inputSearch.value)
  .then(res => {
    console.log('handleSearch res', res)
    res.data.forEach(item => {
      item.createdate = new Date(item.createdate).toLocaleDateString()
    })
    tableData.value = res.data
  })
  .catch(err => {
    console.log('handleSearch err', err)
  })
  console.log('handleSearch', inputSearch)
  inputSearch.value = '';
}

const clearForm = () => {
  formInline.username = '';
  formInline.nickname = '';
}


const addEvent = () => {
  dialogVisible.value = true;
  EditTrigger = false;
}

const editEvent = (row, event) => {
  EditTrigger = true;
  dialogVisible.value = true;
  formInline.username = row.username;
  formInline.nickname = row.nickname;
  formInline.id = row.id;
  formInline.createDate = row.createDate;
  console.log('editEvent', row)
}

const deleteEvent = (id, event) => {
  removeUser(id)
  .then(res => {
    initInfo()
    console.log('deleteEvent res', res)
  })
  .catch(err => {
    console.log('deleteEvent err', err)
  })
  console.log('deleteEvent', id)
}

const handleClose = () => {
  console.log('handleClose')
}

const handleConfirm = () => {
  dialogVisible.value = false
  console.log('handleAddConfirm', formInline)
  if (!formInline.username || !formInline.nickname) {
    return
  }
  if (!EditTrigger) {
    addUser(formInline)
    .then(res => {
      initInfo()
      console.log('addEvent res', res)
    })
    .catch(err => {
      console.log('addEvent err', err)
    })
  } else {
    updateUser(formInline)
    .then(res => {
      initInfo()
      console.log('editEvent res', res)
    })
    .catch(err => {
      console.log('editEvent err', err)
    })
  }
  
  clearForm()

}

const handleCancle = () => {
  dialogVisible.value = false
  console.log('handleCancle')
  clearForm()

}
</script>

<style scoped></style>
