<div class="tab-pane" id="tab3A">
            <div margin:0 auto>
              请输入模型类型：
               <select name="type1" style="width:100px;  height:20px">
                        <option >海洋环境</option>
                        <option >潜艇</option>
                        <option >水面舰</option>
                        <option >鱼雷</option>
                </select>
            </div>
            <table border="0" style="width: 100%;">
              <tbody>
                <tr>
                  <td>目标类型</td>
                  <td><select name="type2" style="width:75px; height:20px">
                      <option >001</option>
                    </select>
                  </td>
                  <td>输出频率范围</td>
                  <td><input name="fre1" style="width:60px;" type="text"></td>
                  <td><input name="fre1" style="width:60px;" type="text"></td>
                  <td>模拟增益/dB</td>
                  <td><input name="zy2" style="width:60px;" type="text"></td>
                </tr>
                <tr>
                  <td>吨位/t</td>
                  <td><input name="weight" style="width:60px;" type="text"></td>
                  <td>灵敏度/dB</td>
                  <td><input name="lm1" style="width:60px;" type="text"></td>
                  <td></td>
                  <td>模拟采样率</td>
                  <td><input name="ss" style="width:60px;" type="text"></td>
                </tr>
                <tr>
                  <td>吃水深度/m</td>
                  <td><input name="depth" style="width:60px;" type="text"></td>
                  <td>带通滤波频率</td>
                  <td><input name="fre2" style="width:60px;" type="text"></td>
                  <td><input name="fre2" style="width:60px;" type="text"></td>
                  <td>模拟灵敏度</td>
                  <td><input name="lm2" style="width:60px;" type="text"></td>
                </tr>
                <tr>
                  <td>采样率/kHz</td>
                  <td><input name="cy1" style="width:60px;" type="text"></td>
                  <td>数据起始时刻</td>
                  <td><input name="time1" style="width:60px;" type="text"></td>
                  <td></td>
                </tr>
                <tr>
                  <td>数据总长度</td>
                  <td><input name="time2" style="width:60px;" type="text"></td>
                  <td>增益</td>
                  <td><input name="zy1" style="width:60px;" type="text"></td>
                  <td></td>
                </tr>
                <tr>
                  <td>阵元个数</td>
                  <td><input name="num" style="width:60px;" type="text"></td>
                  <td>航速/kn</td>
                  <td><input name="speed" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                </tr>
              </tbody>
            </table>
            <input type="button" class="btn btn-warning" value="保存数据"
							onClick="autoGetVal('tab3A','3A','3A');">
						<input type="button" class="btn btn-success" value="开始仿真"
							onClick="run('tab3A','3A');">
          </div>