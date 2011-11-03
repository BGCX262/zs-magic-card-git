package com.ifree.magiccard.data;

public abstract class BaseData {
	
	public abstract byte[] StringtoBytes();
	
	public abstract void BytesToString(byte[] data);
}
