<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item v-if="type!='info'" label="订单id" prop="orderid">
            <el-input v-model="ruleForm.orderid" 
                placeholder="订单id" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.orderid" label="订单id" prop="orderid">
              <el-input v-model="ruleForm.orderid" 
                placeholder="订单id" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商品表名" prop="tablename">
          <el-input v-model="ruleForm.tablename" 
              placeholder="商品表名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tablename" label="商品表名" prop="tablename">
              <el-input v-model="ruleForm.tablename" 
                placeholder="商品表名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商品id" prop="goodid">
          <el-input v-model="ruleForm.goodid" 
              placeholder="商品id" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.goodid" label="商品id" prop="goodid">
              <el-input v-model="ruleForm.goodid" 
                placeholder="商品id" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商品名称" prop="goodname">
          <el-input v-model="ruleForm.goodname" 
              placeholder="商品名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.goodname" label="商品名称" prop="goodname">
              <el-input v-model="ruleForm.goodname" 
                placeholder="商品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="商品图片" prop="picture">
          <file-upload
          tip="点击上传商品图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.picture?ruleForm.picture:''"
          @change="pictureUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.picture" label="商品图片" prop="picture">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.picture.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="购买数量" prop="buynumber">
          <el-input v-model="ruleForm.buynumber" 
              placeholder="购买数量" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.buynumber" label="购买数量" prop="buynumber">
              <el-input v-model="ruleForm.buynumber" 
                placeholder="购买数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="价格/积分" prop="price">
          <el-input v-model="ruleForm.price" 
              placeholder="价格/积分" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.price" label="价格/积分" prop="price">
              <el-input v-model="ruleForm.price" 
                placeholder="价格/积分" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="折扣价格" prop="discountprice">
          <el-input v-model="ruleForm.discountprice" 
              placeholder="折扣价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.discountprice" label="折扣价格" prop="discountprice">
              <el-input v-model="ruleForm.discountprice" 
                placeholder="折扣价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="总价格/总积分" prop="total">
          <el-input v-model="ruleForm.total" 
              placeholder="总价格/总积分" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.total" label="总价格/总积分" prop="total">
              <el-input v-model="ruleForm.total" 
                placeholder="总价格/总积分" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="折扣总价格" prop="discounttotal">
          <el-input v-model="ruleForm.discounttotal" 
              placeholder="折扣总价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.discounttotal" label="折扣总价格" prop="discounttotal">
              <el-input v-model="ruleForm.discounttotal" 
                placeholder="折扣总价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="支付类型（1：现金 2：积分）" prop="type">
          <el-input v-model="ruleForm.type" 
              placeholder="支付类型（1：现金 2：积分）" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.type" label="支付类型（1：现金 2：积分）" prop="type">
              <el-input v-model="ruleForm.type" 
                placeholder="支付类型（1：现金 2：积分）" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="状态" prop="status">
          <el-input v-model="ruleForm.status" 
              placeholder="状态" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.status" label="状态" prop="status">
              <el-input v-model="ruleForm.status" 
                placeholder="状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="地址" prop="address">
          <el-input v-model="ruleForm.address" 
              placeholder="地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.address" label="地址" prop="address">
              <el-input v-model="ruleForm.address" 
                placeholder="地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                          <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        orderid: this.getUUID(),
                                tablename: '',
                                userid: '',
                                goodid: '',
                                goodname: '',
                                picture: '',
                                buynumber: '',
                                price: '',
                                discountprice: '',
                                total: '',
                                discounttotal: '',
                                type: '',
                                status: '',
                                address: '',
                      },
                                                                                                                                                                                                                rules: {
                  orderid: [
                            { required: true, message: '订单id不能为空', trigger: 'blur' },
                                                                                              ],
                  tablename: [
                                                                                              ],
                  userid: [
                            { required: true, message: '用户id不能为空', trigger: 'blur' },
                                                                                              ],
                  goodid: [
                            { required: true, message: '商品id不能为空', trigger: 'blur' },
                                                                                              ],
                  goodname: [
                                                                                              ],
                  picture: [
                                                                                              ],
                  buynumber: [
                            { required: true, message: '购买数量不能为空', trigger: 'blur' },
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  price: [
                            { required: true, message: '价格/积分不能为空', trigger: 'blur' },
                                                    { validator: validateNumber, trigger: 'blur' },
                                                                      ],
                  discountprice: [
                                                    { validator: validateNumber, trigger: 'blur' },
                                                                      ],
                  total: [
                            { required: true, message: '总价格/总积分不能为空', trigger: 'blur' },
                                                    { validator: validateNumber, trigger: 'blur' },
                                                                      ],
                  discounttotal: [
                                                    { validator: validateNumber, trigger: 'blur' },
                                                                      ],
                  type: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  status: [
                                                                                              ],
                  address: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                                              },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='orderid'){
            this.ruleForm.orderid = obj[o];
            continue;
          }
                    if(o=='tablename'){
            this.ruleForm.tablename = obj[o];
            continue;
          }
                    if(o=='userid'){
            this.ruleForm.userid = obj[o];
            continue;
          }
                    if(o=='goodid'){
            this.ruleForm.goodid = obj[o];
            continue;
          }
                    if(o=='goodname'){
            this.ruleForm.goodname = obj[o];
            continue;
          }
                    if(o=='picture'){
            this.ruleForm.picture = obj[o];
            continue;
          }
                    if(o=='buynumber'){
            this.ruleForm.buynumber = obj[o];
            continue;
          }
                    if(o=='price'){
            this.ruleForm.price = obj[o];
            continue;
          }
                    if(o=='discountprice'){
            this.ruleForm.discountprice = obj[o];
            continue;
          }
                    if(o=='total'){
            this.ruleForm.total = obj[o];
            continue;
          }
                    if(o=='discounttotal'){
            this.ruleForm.discounttotal = obj[o];
            continue;
          }
                    if(o=='type'){
            this.ruleForm.type = obj[o];
            continue;
          }
                    if(o=='status'){
            this.ruleForm.status = obj[o];
            continue;
          }
                    if(o=='address'){
            this.ruleForm.address = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                          },
                                                                                                                        // 多级联动参数
                                                                                                                                                        info(id) {
      this.$http({
        url: `orders/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `orders/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.ordersCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.ordersCrossAddOrUpdateFlag = false;
    },
                                                                                    pictureUploadChange(fileUrls) {
                this.ruleForm.picture = fileUrls;
            },
                                                                                                              }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
