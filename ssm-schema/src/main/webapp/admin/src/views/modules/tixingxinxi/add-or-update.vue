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
        <el-form-item  v-if="type!='info'"  label="合同编号" prop="hetongbianhao">
          <el-input v-model="ruleForm.hetongbianhao" 
              placeholder="合同编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.hetongbianhao" label="合同编号" prop="hetongbianhao">
              <el-input v-model="ruleForm.hetongbianhao" 
                placeholder="合同编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房源名称" prop="fangyuanmingcheng">
          <el-input v-model="ruleForm.fangyuanmingcheng" 
              placeholder="房源名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangyuanmingcheng" label="房源名称" prop="fangyuanmingcheng">
              <el-input v-model="ruleForm.fangyuanmingcheng" 
                placeholder="房源名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="入住时间" prop="ruzhushijian">
          <el-input v-model="ruleForm.ruzhushijian" 
              placeholder="入住时间" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.ruzhushijian" label="入住时间" prop="ruzhushijian">
              <el-input v-model="ruleForm.ruzhushijian" 
                placeholder="入住时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="终止时间" prop="zhongzhishijian">
          <el-input v-model="ruleForm.zhongzhishijian" 
              placeholder="终止时间" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhongzhishijian" label="终止时间" prop="zhongzhishijian">
              <el-input v-model="ruleForm.zhongzhishijian" 
                placeholder="终止时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客账号" prop="zukezhanghao">
          <el-input v-model="ruleForm.zukezhanghao" 
              placeholder="租客账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukezhanghao" label="租客账号" prop="zukezhanghao">
              <el-input v-model="ruleForm.zukezhanghao" 
                placeholder="租客账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客姓名" prop="zukexingming">
          <el-input v-model="ruleForm.zukexingming" 
              placeholder="租客姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukexingming" label="租客姓名" prop="zukexingming">
              <el-input v-model="ruleForm.zukexingming" 
                placeholder="租客姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="提醒内容" prop="tixingneirong">
          <el-input v-model="ruleForm.tixingneirong" 
              placeholder="提醒内容" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tixingneirong" label="提醒内容" prop="tixingneirong">
              <el-input v-model="ruleForm.tixingneirong" 
                placeholder="提醒内容" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="发布时间" prop="fabushijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.fabushijian" 
                type="datetime"
                placeholder="发布时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
              <el-input v-model="ruleForm.fabushijian" 
                placeholder="发布时间" readonly></el-input>
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
                        hetongbianhao: '',
                                fangyuanmingcheng: '',
                                ruzhushijian: '',
                                zhongzhishijian: '',
                                zukezhanghao: '',
                                zukexingming: '',
                                tixingneirong: '',
                                fabushijian: '',
                      },
                                                                                                                            rules: {
                  hetongbianhao: [
                                                                                              ],
                  fangyuanmingcheng: [
                                                                                              ],
                  ruzhushijian: [
                                                                                              ],
                  zhongzhishijian: [
                                                                                              ],
                  zukezhanghao: [
                                                                                              ],
                  zukexingming: [
                                                                                              ],
                  tixingneirong: [
                                                                                              ],
                  fabushijian: [
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
                    if(o=='hetongbianhao'){
            this.ruleForm.hetongbianhao = obj[o];
            continue;
          }
                    if(o=='fangyuanmingcheng'){
            this.ruleForm.fangyuanmingcheng = obj[o];
            continue;
          }
                    if(o=='ruzhushijian'){
            this.ruleForm.ruzhushijian = obj[o];
            continue;
          }
                    if(o=='zhongzhishijian'){
            this.ruleForm.zhongzhishijian = obj[o];
            continue;
          }
                    if(o=='zukezhanghao'){
            this.ruleForm.zukezhanghao = obj[o];
            continue;
          }
                    if(o=='zukexingming'){
            this.ruleForm.zukexingming = obj[o];
            continue;
          }
                    if(o=='tixingneirong'){
            this.ruleForm.tixingneirong = obj[o];
            continue;
          }
                    if(o=='fabushijian'){
            this.ruleForm.fabushijian = obj[o];
            continue;
          }
                  }
                                                                                                                                              }
                                                                                                                                                                              },
                                                                        // 多级联动参数
                                                                                            info(id) {
      this.$http({
        url: `tixingxinxi/info/${id}`,
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
                                                                                                                                                                                    this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `tixingxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.tixingxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.tixingxinxiCrossAddOrUpdateFlag = false;
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
