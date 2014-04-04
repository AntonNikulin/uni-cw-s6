// l241_6.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	int sum = 0;
	int N = 1;
	long RESULTS[6];		//array to store results
	short tmp;

	__asm{
						;init denom
		mov ebx, N			
		add ebx, 5
		push ebx			;save denominator

						;Numerator: raising to power
		mov ebx, N			;prep for raising into N
		mov DX, 0			;clear dx for future
		mov AX, 3			;number to raise, initial run
		mov CX, bx			;raise into
		mov bx, 3			;number to raise, ax mult on bx
		dec CX				;magic
		cmp cx, 0			;if cx == 0, we've raised ax into power of 1. jump to avoid infinite loop
		je il
	a1:	mul bx				;multiplies ax by the value of corresp byte-length in the AX		
		loop a1				;Result of power raising in DX:AX

	il:	mov dx, ax	
		mov eax,0
		mov	ax, dx
		pop edi
		cdq					;magic
		div edi
		shr edi, 1
		cmp edi, edx
		adc eax, 0

	}

	return 0;
}

