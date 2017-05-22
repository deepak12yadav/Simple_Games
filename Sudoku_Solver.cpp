#include<bits/stdc++.h>
using namespace std;
#define fori(a,b) for(lli (i)=(lli)(a);(i)<=(lli)(b);(i)++)
#define forj(a,b) for(lli (j)=(lli)(a);(j)<=(lli)(b);(j)++)
#define fork(a,b) for(lli (k)=(lli)(a);(k)<=(lli)(b);(k)++)
#define pb push_back
#define mp make_pair
#define f first
#define s second
#define inf 1000000007
#define pi 3.14159265359
#define fastio ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
#define sz(a) (lli)(a).size()
#define iter(a) typeof((a).begin())
typedef int lli;
typedef vector< lli > vlli;
typedef pair<lli,lli> plli;
typedef set<lli> slli;
typedef map<lli,lli> mlli;

bool check(int value,pair<int,int> pos,vector<set<int> >&R,vector<set<int> >&C,vector<vector<vlli > >&CO,int qq){
    if(R[pos.f].count(value)==1 || C[pos.s].count(value)==1 || CO[(pos.f-1)/(qq+1)][(pos.s-1)/(qq+1)][value]>=1)
        return false;
    return true;
}
void DP(vector<plli>&MAP,int pos,vector<vector<set<int> > >&S,vector<vector<vlli > >&CO,vector<vlli>&V,lli &success,vector<set<int> >&R,vector<set<int> >&C,int qq){
    
    //cout<<MAP[pos].f<<" "<<MAP[pos].s<<endl;
    for (auto it = S[MAP[pos].f][MAP[pos].s].begin(); it != S[MAP[pos].f][MAP[pos].s].end(); it++) {
        //cout<<*it<<endl;
        if(success==1)
            return;
        if(check(*it,MAP[pos],R,C,CO,qq)){
            V[MAP[pos].f][MAP[pos].s]=*it;
            if(pos==sz(MAP)-1){
                success=1;
                return;
            }
            CO[(MAP[pos].f-1)/(qq+1)][(MAP[pos].s-1)/(qq+1)][*it]++;
            R[MAP[pos].f].insert(*it);
            C[MAP[pos].s].insert(*it);
            DP(MAP,pos+1,S,CO,V,success,R,C,qq);
            if(success!=1){
                CO[(MAP[pos].f-1)/(qq+1)][(MAP[pos].s-1)/(qq+1)][*it]--;
                R[MAP[pos].f].erase(*it);
                C[MAP[pos].s].erase(*it);
            }
        }
        
    }
}


int main()
{   
    lli t,a,n,k1,b,c;
    cin>>k1;
    n=3;
    vector<vlli>V(n*n+1,vlli(n*n+1,0));
    vector<set<int> >R(n*n+1);
    vector<set<int> >C(n*n+1);
    vector<vector<vlli > >CO(n+1,vector<vlli >(n+1,vlli(n*n+1,0)));
    vector<vector<set<int> > >S(n*n+1,vector<set<int> >(n*n+1));
    set<int>SSS;
    fori(1,n*n){
        SSS.insert(i);
    }
    fori(1,k1){
        cin>>a>>b>>c;
        V[a][b]=c;
    }
    int flag=0;
    fori(1,n*n){
        forj(1,n*n){
            if(V[i][j]!=0){
                R[i].insert(V[i][j]);
                C[j].insert(V[i][j]);
                CO[(i-1)/(n)][(j-1)/(n)][V[i][j]]++;
            }
        }
    }
    vector<plli>MAP;        //Creating map
    fori(1,n*n){
        forj(1,n*n){
            if(V[i][j]!=0)
                continue;
            S[i][j]=set<int>(SSS);
            for (auto it = R[i].begin(); it != R[i].end(); it++) {
                S[i][j].erase(*it);
            }
            for (auto it = C[j].begin(); it != C[j].end(); it++) {
                S[i][j].erase(*it);
            }
            fork(1,n*n){
                if(CO[(i-1)/(n)][(j-1)/(n)][k]==1)
                    S[i][j].erase(k);
            }
            //cout<<i<<" "<<j<<" "<<S[i][j].size()<<endl;
            MAP.push_back({i,j});
        }
    }
    int success=0;
    if(MAP.size()!=0){
        DP(MAP,0,S,CO,V,success,R,C,n-1);
    }
    if(success!=1){
        cout<<"Not Solvable (check the input again)\n";
    }
    else
    fori(1,n*n){
        forj(1,n*n){
            printf("%d ",V[i][j]);
        }
        printf("\n");
    }
    

    
    return 0;
}
