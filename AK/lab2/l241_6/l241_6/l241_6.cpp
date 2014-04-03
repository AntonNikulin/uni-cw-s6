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
		mov DX,0; регистр DX пригодится в дальнейшем
		mov AX,Num1; число которое будут возводить в степень
		mov CX,Num2; степень числа
		dec CX
	a1:	mul Num1
		loop a1
; результат в DX:AX
	}
	return 0;
}

