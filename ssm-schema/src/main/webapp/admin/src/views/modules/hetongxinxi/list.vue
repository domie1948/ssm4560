<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="合同编号">
                <el-input v-model="searchForm.hetongbianhao" 
                    placeholder="合同编号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="房源名称">
                <el-input v-model="searchForm.fangyuanmingcheng" 
                    placeholder="房源名称" clearable></el-input>
              </el-form-item>
                                                                                                                                                                                                                                    <el-form-item label="房东账号">
                <el-input v-model="searchForm.fangdongzhanghao" 
                    placeholder="房东账号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="房东姓名">
                <el-input v-model="searchForm.fangdongxingming" 
                    placeholder="房东姓名" clearable></el-input>
              </el-form-item>
                                                                                    <el-form-item label="租客账号">
                <el-input v-model="searchForm.zukezhanghao" 
                    placeholder="租客账号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="租客姓名">
                <el-input v-model="searchForm.zukexingming" 
                    placeholder="租客姓名" clearable></el-input>
              </el-form-item>
                                                                                            <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('hetongxinxi','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('hetongxinxi','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('hetongxinxi','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="hetongbianhao"
                    header-align="center"
                    align="center"
                    sortable
                    label="合同编号">
                    <template slot-scope="scope">
                      {{scope.row.hetongbianhao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="fangyuanmingcheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="房源名称">
                    <template slot-scope="scope">
                      {{scope.row.fangyuanmingcheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="geju"
                    header-align="center"
                    align="center"
                    sortable
                    label="格局">
                    <template slot-scope="scope">
                      {{scope.row.geju}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="mianji"
                    header-align="center"
                    align="center"
                    sortable
                    label="面积">
                    <template slot-scope="scope">
                      {{scope.row.mianji}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="dizhi"
                    header-align="center"
                    align="center"
                    sortable
                    label="地址">
                    <template slot-scope="scope">
                      {{scope.row.dizhi}}
                    </template>
                </el-table-column>
                                                              <el-table-column prop="tupian" 
                    header-align="center"
                    align="center" 
                    width="200" 
                    label="图片">
                    <template slot-scope="scope">
                      <div v-if="scope.row.tupian">
                        <img :src="scope.row.tupian.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                                                            <el-table-column
                    prop="jiage"
                    header-align="center"
                    align="center"
                    sortable
                    label="价格">
                    <template slot-scope="scope">
                      {{scope.row.jiage}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zuqi"
                    header-align="center"
                    align="center"
                    sortable
                    label="租期">
                    <template slot-scope="scope">
                      {{scope.row.zuqi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zongjine"
                    header-align="center"
                    align="center"
                    sortable
                    label="总金额">
                    <template slot-scope="scope">
                      {{scope.row.zongjine}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="ruzhushijian"
                    header-align="center"
                    align="center"
                    sortable
                    label="入住时间">
                    <template slot-scope="scope">
                      {{scope.row.ruzhushijian}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zhongzhishijian"
                    header-align="center"
                    align="center"
                    sortable
                    label="终止时间">
                    <template slot-scope="scope">
                      {{scope.row.zhongzhishijian}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="fangdongzhanghao"
                    header-align="center"
                    align="center"
                    sortable
                    label="房东账号">
                    <template slot-scope="scope">
                      {{scope.row.fangdongzhanghao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="fangdongxingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="房东姓名">
                    <template slot-scope="scope">
                      {{scope.row.fangdongxingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="lianxidianhua"
                    header-align="center"
                    align="center"
                    sortable
                    label="联系电话">
                    <template slot-scope="scope">
                      {{scope.row.lianxidianhua}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zukezhanghao"
                    header-align="center"
                    align="center"
                    sortable
                    label="租客账号">
                    <template slot-scope="scope">
                      {{scope.row.zukezhanghao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zukexingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="租客姓名">
                    <template slot-scope="scope">
                      {{scope.row.zukexingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="lianxifangshi"
                    header-align="center"
                    align="center"
                    sortable
                    label="联系方式">
                    <template slot-scope="scope">
                      {{scope.row.lianxifangshi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="qiandingshijian"
                    header-align="center"
                    align="center"
                    sortable
                    label="签订时间">
                    <template slot-scope="scope">
                      {{scope.row.qiandingshijian}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                  prop="ispay"
                  header-align="center"
                  align="center"
                  sortable
                  label="是否支付">
                  <template slot-scope="scope">
                    <span style="margin-right:10px">{{scope.row.ispay=='已支付'?'已支付':'未支付'}}</span>
                    <el-button v-if="scope.row.ispay!='已支付' && isAuth('hetongxinxi','支付') " type="text" icon="el-icon-edit" size="small" @click="payHandler(scope.row)">支付</el-button>
                  </template>
                </el-table-column>
                                                    <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('hetongxinxi','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                                <el-button v-if="isAuth('hetongxinxi','退房')" type="text" icon="el-icon-edit" size="small" @click="tuifangxinxiCrossAddOrUpdateHandler(scope.row,'cross')">退房</el-button>
                                                <el-button v-if="isAuth('hetongxinxi','退款')" type="text" icon="el-icon-edit" size="small" @click="tuikuanxinxiCrossAddOrUpdateHandler(scope.row,'cross')">退款</el-button>
                                                <el-button v-if="isAuth('hetongxinxi','提醒')" type="text" icon="el-icon-edit" size="small" @click="tixingxinxiCrossAddOrUpdateHandler(scope.row,'cross')">提醒</el-button>
                                                                <el-button v-if="isAuth('hetongxinxi','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('hetongxinxi','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                                                                                                                                                                                                                                <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

            <tuifangxinxi-cross-add-or-update v-if="tuifangxinxiCrossAddOrUpdateFlag" :parent="this" ref="tuifangxinxiCrossaddOrUpdate"></tuifangxinxi-cross-add-or-update>
        <tuikuanxinxi-cross-add-or-update v-if="tuikuanxinxiCrossAddOrUpdateFlag" :parent="this" ref="tuikuanxinxiCrossaddOrUpdate"></tuikuanxinxi-cross-add-or-update>
        <tixingxinxi-cross-add-or-update v-if="tixingxinxiCrossAddOrUpdateFlag" :parent="this" ref="tixingxinxiCrossaddOrUpdate"></tixingxinxi-cross-add-or-update>
        
    
      </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
import tuifangxinxiCrossAddOrUpdate from "../tuifangxinxi/add-or-update";
import tuikuanxinxiCrossAddOrUpdate from "../tuikuanxinxi/add-or-update";
import tixingxinxiCrossAddOrUpdate from "../tixingxinxi/add-or-update";
export default {
  data() {
    return {
                                                                                                                                                                                                                                                                                                                                                                                                                                          searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
                  tuifangxinxiCrossAddOrUpdateFlag: false,
            tuikuanxinxiCrossAddOrUpdateFlag: false,
            tixingxinxiCrossAddOrUpdateFlag: false,
                };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
            tuifangxinxiCrossAddOrUpdate,
        tuikuanxinxiCrossAddOrUpdate,
        tixingxinxiCrossAddOrUpdate,
          },
  methods: {
            tuifangxinxiCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.tuifangxinxiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','hetongxinxi');
      this.$nextTick(() => {
        this.$refs.tuifangxinxiCrossaddOrUpdate.init(row.id,type);
      });
    },
        tuikuanxinxiCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.tuikuanxinxiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','hetongxinxi');
      this.$nextTick(() => {
        this.$refs.tuikuanxinxiCrossaddOrUpdate.init(row.id,type);
      });
    },
        tixingxinxiCrossAddOrUpdateHandler(row,type){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.tixingxinxiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','hetongxinxi');
      this.$nextTick(() => {
        this.$refs.tixingxinxiCrossaddOrUpdate.init(row.id,type);
      });
    },
                payHandler(row){
      this.$storage.set('paytable','hetongxinxi');
      this.$storage.set('payObject',row);
      this.$router.push('pay');
    },
            init () {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                          if(this.searchForm.hetongbianhao!='' && this.searchForm.hetongbianhao!=undefined){
            params['hetongbianhao'] = '%' + this.searchForm.hetongbianhao + '%'
          }
                                                            if(this.searchForm.fangyuanmingcheng!='' && this.searchForm.fangyuanmingcheng!=undefined){
            params['fangyuanmingcheng'] = '%' + this.searchForm.fangyuanmingcheng + '%'
          }
                                                                                                                                                                                                                                                                  if(this.searchForm.fangdongzhanghao!='' && this.searchForm.fangdongzhanghao!=undefined){
            params['fangdongzhanghao'] = '%' + this.searchForm.fangdongzhanghao + '%'
          }
                                                            if(this.searchForm.fangdongxingming!='' && this.searchForm.fangdongxingming!=undefined){
            params['fangdongxingming'] = '%' + this.searchForm.fangdongxingming + '%'
          }
                                                                                  if(this.searchForm.zukezhanghao!='' && this.searchForm.zukezhanghao!=undefined){
            params['zukezhanghao'] = '%' + this.searchForm.zukezhanghao + '%'
          }
                                                            if(this.searchForm.zukexingming!='' && this.searchForm.zukexingming!=undefined){
            params['zukexingming'] = '%' + this.searchForm.zukexingming + '%'
          }
                                                                                                this.$http({
        url: "hetongxinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "hetongxinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
