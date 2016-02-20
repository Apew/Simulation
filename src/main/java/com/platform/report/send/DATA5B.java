package com.platform.report.send;

import java.io.Serializable;

/**
 * 
 * @author liukang
 * 模型5仿真用(模型6B通用)
 */
public class DATA5B implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5685529889716393607L;
	
	private char s1;   //标识
	private float weight;       //吨位
	private float depth;        //水深
	private float speed;        //航速
	private float[] fre1 = new float[2];      //输出频率1-2
	private float cy1;          //采样率
	private float zy1;          //增益
	private float lm1;          //灵敏度
	private float num1; //阵元个数
	private float ss;           //速度对应谱级
	private float fre2;         //轴频频率
	private float num2; //螺旋桨叶片数
	private float[] xp1 = new float[20];      //线谱频率20
	private float[] xp2 = new float[20];      //线谱强度20
	private float[] de = new float[20];       //调制深度20
	private float[] rela = new float[48];     //相关系数48
	private char type1;//仿真类型
	private char type2;//目标类型
	public char getS1() {
		return s1;
	}
	public void setS1(char s1) {
		this.s1 = s1;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getDepth() {
		return depth;
	}
	public void setDepth(float depth) {
		this.depth = depth;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float[] getFre1() {
		return fre1;
	}
	public void setFre1(float[] fre1) {
		this.fre1 = fre1;
	}
	public float getCy1() {
		return cy1;
	}
	public void setCy1(float cy1) {
		this.cy1 = cy1;
	}
	public float getZy1() {
		return zy1;
	}
	public void setZy1(float zy1) {
		this.zy1 = zy1;
	}
	public float getLm1() {
		return lm1;
	}
	public void setLm1(float lm1) {
		this.lm1 = lm1;
	}
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getSs() {
		return ss;
	}
	public void setSs(float ss) {
		this.ss = ss;
	}
	public float getFre2() {
		return fre2;
	}
	public void setFre2(float fre2) {
		this.fre2 = fre2;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	public float[] getXp1() {
		return xp1;
	}
	public void setXp1(float[] xp1) {
		this.xp1 = xp1;
	}
	public float[] getXp2() {
		return xp2;
	}
	public void setXp2(float[] xp2) {
		this.xp2 = xp2;
	}
	public float[] getDe() {
		return de;
	}
	public void setDe(float[] de) {
		this.de = de;
	}
	public float[] getRela() {
		return rela;
	}
	public void setRela(float[] rela) {
		this.rela = rela;
	}
	public char getType1() {
		return type1;
	}
	public void setType1(char type1) {
		this.type1 = type1;
	}
	public char getType2() {
		return type2;
	}
	public void setType2(char type2) {
		this.type2 = type2;
	}
	
	
}
