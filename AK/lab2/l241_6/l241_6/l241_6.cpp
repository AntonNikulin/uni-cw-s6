// l241_6.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	int sum = 0;
	long N = 1;
	short Num1 = 3;
	short Num2 =2;
	__asm{
		mov DX,0; ������� DX ���������� � ����������
		mov AX,Num1; ����� ������� ����� ��������� � �������
		mov CX,Num2; ������� �����
		dec CX
	a1:	mul Num1
		loop a1
; ��������� � DX:AX
	}
	return 0;
}

