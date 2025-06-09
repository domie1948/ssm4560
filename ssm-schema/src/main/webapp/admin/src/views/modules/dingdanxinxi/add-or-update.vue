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
        <el-form-item v-if="type!='info'" label="订单编号" prop="dingdanbianhao">
            <el-input v-model="ruleForm.dingdanbianhao" 
                placeholder="订单编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dingdanbianhao" label="订单编号" prop="dingdanbianhao">
              <el-input v-model="ruleForm.dingdanbianhao" 
                placeholder="订单编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商家号" prop="shangjiahao">
          <el-input v-model="ruleForm.shangjiahao" 
              placeholder="商家号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangjiahao" label="商家号" prop="shangjiahao">
              <el-input v-model="ruleForm.shangjiahao" 
                placeholder="商家号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="菜品编号" prop="caipinbianhao">
          <el-input v-model="ruleForm.caipinbianhao" 
              placeholder="菜品编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caipinbianhao" label="菜品编号" prop="caipinbianhao">
              <el-input v-model="ruleForm.caipinbianhao" 
                placeholder="菜品编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="菜品名称" prop="caipinmingcheng">
          <el-input v-model="ruleForm.caipinmingcheng" 
              placeholder="菜品名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caipinmingcheng" label="菜品名称" prop="caipinmingcheng">
              <el-input v-model="ruleForm.caipinmingcheng" 
                placeholder="菜品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="数量" prop="shuliang">
          <el-input v-model="ruleForm.shuliang" 
              placeholder="数量" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shuliang" label="数量" prop="shuliang">
              <el-input v-model="ruleForm.shuliang" 
                placeholder="数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="价格" prop="jiage">
          <el-input v-model="ruleForm.jiage" 
              placeholder="价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiage" label="价格" prop="jiage">
              <el-input v-model="ruleForm.jiage" 
                placeholder="价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="总金额" prop="zongjine">
            <el-input v-model="zongjine"
                placeholder="总金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zongjine" label="总金额" prop="zongjine">
              <el-input v-model="ruleForm.zongjine" 
                placeholder="总金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.lianxidianhua" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="收货地址" prop="shouhuodizhi">
          <el-input v-model="ruleForm.shouhuodizhi" 
              placeholder="收货地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shouhuodizhi" label="收货地址" prop="shouhuodizhi">
              <el-input v-model="ruleForm.shouhuodizhi" 
                placeholder="收货地址" readonly></el-input>
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
                        dingdanbianhao: this.getUUID(),
                                shangjiahao: '',
                                caipinbianhao: '',
                                caipinmingcheng: '',
                                shuliang: '',
                                jiage: '',
                                zongjine: '',
                                yonghuming: '',
                                lianxidianhua: '',
                                shouhuodizhi: '',
                                sfsh: '',
                                shhf: '',
                                ispay: '',
                      },
                                                                                                                                                                                                  rules: {
                  dingdanbianhao: [
                                                                                              ],
                  shangjiahao: [
                                                                                              ],
                  caipinbianhao: [
                                                                                              ],
                  caipinmingcheng: [
                                                                                              ],
                  shuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  jiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zongjine: [
                                                                                              ],
                  yonghuming: [
                                                                                              ],
                  lianxidianhua: [
                                                                { validator: validatePhone, trigger: 'blur' },
                                                          ],
                  shouhuodizhi: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
                                                                                              ],
                  ispay: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                    zongjine:{
                                                                                                                                                                                                                  get: function () {
        return 1*this.ruleForm.shuliang*this.ruleForm.jiage
      }
    },
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
                    if(o=='dingdanbianhao'){
            this.ruleForm.dingdanbianhao = obj[o];
            continue;
          }
                    if(o=='shangjiahao'){
            this.ruleForm.shangjiahao = obj[o];
            continue;
          }
                    if(o=='caipinbianhao'){
            this.ruleForm.caipinbianhao = obj[o];
            continue;
          }
                    if(o=='caipinmingcheng'){
            this.ruleForm.caipinmingcheng = obj[o];
            continue;
          }
                    if(o=='shuliang'){
            this.ruleForm.shuliang = obj[o];
            continue;
          }
                    if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
            continue;
          }
                    if(o=='zongjine'){
            this.ruleForm.zongjine = obj[o];
            continue;
          }
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
            continue;
          }
                    if(o=='shouhuodizhi'){
            this.ruleForm.shouhuodizhi = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                    if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
            continue;
          }
                  }
                                                                                        this.ruleForm.shuliang = 0
                                                                                                                                                      }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                              this.ruleForm.yonghuming = json.yonghuming
                                                                                                                                            } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                                        },
                                                                                                                // 多级联动参数
                                                                                                                                              info(id) {
      this.$http({
        url: `dingdanxinxi/info/${id}`,
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
              this.ruleForm.zongjine = this.zongjine
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                        var obj = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      obj.shuliang = obj.shuliang - this.ruleForm.shuliang
      if(obj.shuliang<0){
        this.$message.error("数量不足");
        return
      }
      this.$http({
          url: `${table}/update`,
          method: "post",
          data: obj
        }).then(({ data }) => {});
                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `dingdanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
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
