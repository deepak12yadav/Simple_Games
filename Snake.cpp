#include <iostream>
#include <ctime>
#include<conio.h>
using namespace std;

int size_of_snake=1;




int if_increase_length=0;                           //will see if length is to be increased

int head_x;                                        //have the value of the node currently having head
int head_y;

class dash
{   public:
     int coun_=0;         //to tell till how many iterations it have to follow special directions
    bool if_head=0;

    bool if_activated=0;
    bool if_being_directed=0;
    int directed_x;                  // the line or node to which it is directing
    int directed_y;


    int direction ;                    // if it is 1 means positive if it is -1  means negative

}A[33][17];

void ClearScreen()
    {
    int n;
    for (n = 0; n < 10; n++)
      cout<<"\n\n\n\n\n\n\n\n\n\n" ;
    }




void print()                                      //to print on the screen
{   ClearScreen();
    for(int i=1;i<=33;i++)
    {
         for(int j=1;j<=17;j++)
    {
       if(A[i][j].if_activated==1)
       {
              if(i%2!=0)
        {
            if(A[i][j].if_head==1)
            {


                if(A[i][j].direction==1)
                cout<<"--->";
            else
              cout<<"<---";
            }
            else
            cout<<"----";
        }
        else
        if(A[i][j].if_head==1)
            {


                if(A[i][j].direction==1)
                cout<<"i   ";
            else
              cout<<"!   ";
            }
            else
            cout<<"|   ";

       }
       else
            cout<<"    ";
    }

    cout<<endl;
    }


}

void director_command(int x,int y,int dir)         //directed command for activating the particular nodes in particular direction
{
     int j;

    for(int i=2;i<=31;i++)
    {

      if(i%2!=0)
        j=1;
      else
        j=2;
    for(;j<=16;j++)
    {
        if(A[i][j].if_activated==1)
        {

            if(A[i][j].if_head==1)
            {
                 A[i][j].if_head=0;
                 A[x][y].if_head=1;
                 head_x=x;
                 head_y=y;
                 A[x][y].if_being_directed=1;
                 A[x][y].if_activated=1;
                  A[x][y].direction=dir;
                   A[x][y].coun_=size_of_snake;
                 A[i][j].coun_=size_of_snake-1;


                 A[i][j].directed_x=x;
                 A[i][j].directed_y=y;

                 if(A[i][j].if_being_directed!=1)
                 A[i][j].if_activated=0;
            }

           else
            {

                if(A[i][j].coun_==0)
                {


                       if(i%2!=0)
                      {
                        if(A[i][j].direction==1)
                        {



                           int x=i;
                           int y=j+1;

                           A[x][y].if_being_directed=1;
                           A[x][y].if_activated=1;
                            A[x][y].direction=1;
                           if(A[i][j].if_being_directed!=1)
                           A[i][j].if_activated=0;
                        }
                        else
                        {
                             int x=i;
                           int y=j-1;

                           A[x][y].if_being_directed=1;
                           A[x][y].if_activated=1;
                            A[x][y].direction==-1;
                           if(A[i][j].if_being_directed!=1)
                           A[i][j].if_activated=0;
                        }

                     }
                     else
                     {
                       if(A[i][j].direction==1)
                       {


                         int x=i-2;
                         int y=j;


                         A[x][y].if_being_directed=1;
                         A[x][y].if_activated=1;
                         A[x][y].direction=1;
                         if(A[i][j].if_being_directed!=1)
                          A[i][j].if_activated=0;
                       }
                       else
                       {
                           int x=i+2;
                         int y=j;


                         A[x][y].if_being_directed=1;
                         A[x][y].if_activated=1;
                          A[x][y].direction=-1;
                         if(A[i][j].if_being_directed!=1)
                          A[i][j].if_activated=0;
                       }
                     }
                    // A[i][j].coun_=0;
                }

                  else
                  {
                        A[ A[i][j].directed_x][A[i][j].directed_y].if_being_directed=1;
                        A[ A[i][j].directed_x][A[i][j].directed_y].if_activated=1;

                        if(A[i][j].if_being_directed!=1)
                          A[i][j].if_activated=0;

                        A[i][j].coun_--;
                  }
             }


       }

    }

}


for(int i=2;i<=31;i++)
    {

      if(i%2!=0)
        j=1;
      else
        j=2;
    for(;j<=16;j++)
    {
        if(A[i][j].if_being_directed==1)


        if((A[i][j].coun_==1||A[i][j].coun_==0)&&A[i][j].if_being_directed==1){

        A[i][j].if_being_directed=0;

        }


    }
    }
}



int main()
{
       char c;
       cout<<"GAME FOR PRIMARY SCHOOL STUDENTS -------------------------------------\n";
       cout<<"PRESS ANY KEY FOR NEXT SCREEN  \n";
       getch();
ClearScreen();
cout<<"USE W FOR UP .\n";
cout<<"USE S FOR DOWN .\n";
cout<<"USE D FOR RIGHT .\n";
cout<<"USE A FOR LEFT .\n";
cout<<"BE AWARE THE SIZE OF SNAKE WILL INCREASE CONTINUOUSLY \n";
cout<<"PRESS ANY KEY FOR NEXT SCREEN  \n";
       getch();
ClearScreen();





for(int j=1;j<=16;j++)                                       //   initializing the board
{
    A[1][j].if_activated=1;
     A[33][j].if_activated=1;
}

for(int i=2;i<=32;i+=2)
{
    A[i][1].if_activated=1;
     A[i][17].if_activated=1;
}



A[3][1].if_head=1;
A[3][1].if_activated=1;
A[3][1].direction=1;
head_x=3;
head_y=1;

cout<<"PRESS ANY KEY FOR PLAYING \n";
getch();
 print()  ;

c=getch();
        while(1)
       {
           if (1)                       //limiting the  the input period
           {
                 c=getch();
                 if_increase_length++;

                 if(c=='a')
                             {
                                   if(head_x%2!=0)
                                   director_command(head_x,head_y-1,-1);
                                   else
                                    if(A[head_x][head_y].direction==1)
                                    director_command(head_x-1,head_y-1,-1);
                                   else
                                    director_command(head_x+1,head_y-1,-1);
                             }
                              if(c=='s')
                             {
                                   if(head_x%2==0)
                                   director_command(head_x+2,head_y,-1);
                                   else
                                    if(A[head_x][head_y].direction==1)
                                    director_command(head_x+1,head_y+1,-1);
                                   else
                                    director_command(head_x+1,head_y,-1);
                             }
                              if(c=='d')
                             {
                                   if(head_x%2!=0)
                                   director_command(head_x,head_y+1,1);
                                   else
                                    if(A[head_x][head_y].direction==1)
                                    director_command(head_x-1,head_y,1);
                                   else
                                    director_command(head_x+1,head_y,1);
                             }
                              if(c=='w')
                             {
                                   if(head_x%2==0)
                                   director_command(head_x-2,head_y,1);
                                   else
                                    if(A[head_x][head_y].direction==1)
                                    director_command(head_x-1,head_y+1,1);
                                   else
                                    director_command(head_x-1,head_y,1);
                             }




                              if_increase_length++;



                  if(if_increase_length>=4)                                           // adding the node to increase the snake
              {
                  cout<<"Sorry!!!"<<endl;
                  size_of_snake++;
                  if(head_x%2!=0)
                  {
                      if(A[head_x][head_y].direction==1)
                      {
                          A[head_x][head_y+1].if_activated=1;
                          A[head_x][head_y+1].if_head=1;
                          A[head_x][head_y+1].if_being_directed=1;
                          A[head_x][head_y].if_head=0;
                           A[head_x][head_y+1].direction=1;
                           A[head_x][head_y].coun_= size_of_snake-1;
                           A[head_x][head_y+1].coun_= size_of_snake;
                            A[head_x][head_y].directed_x=head_x;
                            A[head_x][head_y].directed_y=head_y+1;

                           head_y++;
                      }
                      else
                      {
                           A[head_x][head_y-1].if_activated=1;
                          A[head_x][head_y-1].if_head=1;
                          A[head_x][head_y-1].if_being_directed=1;
                          A[head_x][head_y].if_head=0;
                           A[head_x][head_y-1].direction=-1;
                            A[head_x][head_y].coun_= size_of_snake-1;
                            A[head_x][head_y-1].coun_= size_of_snake;
                            A[head_x][head_y].directed_x=head_x;
                            A[head_x][head_y].directed_y=head_y-1;

                           head_y--;
                      }



                  }

                  else
                  {
                      if(A[head_x][head_y].direction==1)
                      {
                          A[head_x-2][head_y].if_activated=1;
                          A[head_x-2][head_y].if_head=1;
                          A[head_x-2][head_y].if_being_directed=1;
                          A[head_x][head_y].if_head=0;
                           A[head_x-2][head_y].direction=1;
                            A[head_x][head_y].coun_= size_of_snake-1;
                             A[head_x-2][head_y].coun_= size_of_snake;
                            A[head_x][head_y].directed_x=head_x-2;
                            A[head_x][head_y].directed_y=head_y;
                           head_x-=2;

                      }
                      else
                      {
                           A[head_x+2][head_y].if_activated=1;
                          A[head_x+2][head_y].if_head=1;
                          A[head_x+2][head_y].if_being_directed=1;
                          A[head_x][head_y].if_head=0;
                          A[head_x+2][head_y].direction=-1;
                           A[head_x][head_y].coun_= size_of_snake-1;
                           A[head_x+2][head_y].coun_= size_of_snake;
                            A[head_x][head_y].directed_x=head_x+2;
                            A[head_x][head_y].directed_y=head_y;
                          head_x+=2;

                      }
                  }

                // if_increase_length=0;                               //again starting from beginning
              }


                        print();


                             if(head_x%2!=0)                                                                // checking if the game is finished
              {
                     if(A[head_x][head_y].direction==1)
                     {
                         if(A[head_x-1][head_y+1].if_activated ==1  &&  A[head_x+1][head_y+1].if_activated==1)
                         {
                             cout<<"Game Over !!!!!!!!!!!!!!!!"<<endl;
                             break;
                         }


                     }
                     else
                        if(A[head_x-1][head_y].if_activated ==1  &&  A[head_x+1][head_y].if_activated==1)
                         {
                             cout<<"Game Over !!!!!!!!!!!!!!!!"<<endl;
                             break;
                         }
              }
              else
              {
                   if(A[head_x][head_y].direction==1)
                     {
                         if(A[head_x-1][head_y-1].if_activated ==1  &&  A[head_x-1][head_y].if_activated==1)
                         {
                             cout<<"Game Over !!!!!!!!!!!!!!!!"<<endl;
                             break;
                         }


                     }
                     else
                        if(A[head_x+1][head_y-1].if_activated ==1  &&  A[head_x+1][head_y].if_activated==1)
                         {
                             cout<<"Game Over !!!!!!!!!!!!!!!!"<<endl;
                             break;
                         }
              }


            }





       }
}
