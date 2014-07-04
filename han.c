/*
 成績の判定プログラム
*/
#include <stdio.h>

main()
{
  int score;  //試験の得点

  //点数の入力
  printf("Input score > ");
  scanf("%d", &score);

  //成績の判定処理
  if(score >= 80)
    printf("Class A\n");
  else if(score >=60)
    printf("Class B\n");
  else
    printf("Out!\n");

  exit(0);
}
