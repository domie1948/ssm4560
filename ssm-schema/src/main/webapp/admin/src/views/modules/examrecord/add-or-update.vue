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
        <el-form-item  v-if="type!='info'"  label="用户名" prop="username">
          <el-input v-model="ruleForm.username" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.username" label="用户名" prop="username">
              <el-input v-model="ruleForm.username" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="试卷id（外键）" prop="paperid">
          <el-input v-model="ruleForm.paperid" 
              placeholder="试卷id（外键）" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.paperid" label="试卷id（外键）" prop="paperid">
              <el-input v-model="ruleForm.paperid" 
                placeholder="试卷id（外键）" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="试卷名称" prop="papername">
          <el-input v-model="ruleForm.papername" 
              placeholder="试卷名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.papername" label="试卷名称" prop="papername">
              <el-input v-model="ruleForm.papername" 
                placeholder="试卷名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="试题id（外键）" prop="questionid">
          <el-input v-model="ruleForm.questionid" 
              placeholder="试题id（外键）" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.questionid" label="试题id（外键）" prop="questionid">
              <el-input v-model="ruleForm.questionid" 
                placeholder="试题id（外键）" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="试题名称" prop="questionname">
          <el-input v-model="ruleForm.questionname" 
              placeholder="试题名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.questionname" label="试题名称" prop="questionname">
              <el-input v-model="ruleForm.questionname" 
                placeholder="试题名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="分值" prop="score">
          <el-input v-model="ruleForm.score" 
              placeholder="分值" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.score" label="分值" prop="score">
              <el-input v-model="ruleForm.score" 
                placeholder="分值" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="正确答案" prop="answer">
          <el-input v-model="ruleForm.answer" 
              placeholder="正确答案" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.answer" label="正确答案" prop="answer">
              <el-input v-model="ruleForm.answer" 
                placeholder="正确答案" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="试题得分" prop="myscore">
          <el-input v-model="ruleForm.myscore" 
              placeholder="试题得分" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.myscore" label="试题得分" prop="myscore">
              <el-input v-model="ruleForm.myscore" 
                placeholder="试题得分" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="考生答案" prop="myanswer">
          <el-input v-model="ruleForm.myanswer" 
              placeholder="考生答案" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.myanswer" label="考生答案" prop="myanswer">
              <el-input v-model="ruleForm.myanswer" 
                placeholder="考生答案" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="选项，json字符串" prop="options">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="选项，json字符串"
                  v-model="ruleForm.options">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.options" label="选项，json字符串" prop="options">
                    <span>{{ruleForm.options}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="答案解析" prop="analysis">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="答案解析"
                  v-model="ruleForm.analysis">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.analysis" label="答案解析" prop="analysis">
                    <span>{{ruleForm.analysis}}</span>
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
                        userid: '',
                                username: '',
                                paperid: '',
                                papername: '',
                                questionid: '',
                                questionname: '',
                                options: '',
                                score: '',
                                answer: '',
                                analysis: '',
                                myscore: '',
                                myanswer: '',
                      },
                                                                                                                                                                                    rules: {
                  userid: [
                            { required: true, message: '用户id不能为空', trigger: 'blur' },
                                                                                              ],
                  username: [
                                                                                              ],
                  paperid: [
                            { required: true, message: '试卷id（外键）不能为空', trigger: 'blur' },
                                                                                              ],
                  papername: [
                            { required: true, message: '试卷名称不能为空', trigger: 'blur' },
                                                                                              ],
                  questionid: [
                            { required: true, message: '试题id（外键）不能为空', trigger: 'blur' },
                                                                                              ],
                  questionname: [
                            { required: true, message: '试题名称不能为空', trigger: 'blur' },
                                                                                              ],
                  options: [
                                                                                              ],
                  score: [
                                                                                              ],
                  answer: [
                                                                                              ],
                  analysis: [
                                                                                              ],
                  myscore: [
                            { required: true, message: '试题得分不能为空', trigger: 'blur' },
                                                                                              ],
                  myanswer: [
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
                    if(o=='userid'){
            this.ruleForm.userid = obj[o];
            continue;
          }
                    if(o=='username'){
            this.ruleForm.username = obj[o];
            continue;
          }
                    if(o=='paperid'){
            this.ruleForm.paperid = obj[o];
            continue;
          }
                    if(o=='papername'){
            this.ruleForm.papername = obj[o];
            continue;
          }
                    if(o=='questionid'){
            this.ruleForm.questionid = obj[o];
            continue;
          }
                    if(o=='questionname'){
            this.ruleForm.questionname = obj[o];
            continue;
          }
                    if(o=='options'){
            this.ruleForm.options = obj[o];
            continue;
          }
                    if(o=='score'){
            this.ruleForm.score = obj[o];
            continue;
          }
                    if(o=='answer'){
            this.ruleForm.answer = obj[o];
            continue;
          }
                    if(o=='analysis'){
            this.ruleForm.analysis = obj[o];
            continue;
          }
                    if(o=='myscore'){
            this.ruleForm.myscore = obj[o];
            continue;
          }
                    if(o=='myanswer'){
            this.ruleForm.myanswer = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                      },
                                                                                                        // 多级联动参数
                                                                                                                                    info(id) {
      this.$http({
        url: `examrecord/info/${id}`,
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
                                                                                                                                                                                                                                                            this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `examrecord/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.examrecordCrossAddOrUpdateFlag = false;
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
      this.parent.examrecordCrossAddOrUpdateFlag = false;
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
