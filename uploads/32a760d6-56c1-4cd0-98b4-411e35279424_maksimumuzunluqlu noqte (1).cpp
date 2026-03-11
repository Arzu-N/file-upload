#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int n,m,i,j,s=0;
	float max=0;
	cin>>n;
	int a[n],b[n],c[n],d[n],l=0,k=0;
	float t[(n*(n-1))];
	for(i=0;i<n;i++){
		cin>>m>>k;
		a[i]=m;
		b[i]=k;
	}
		for(i=0;i<n;i++){
			cout<<a[i]<<" ";}
			cout<<"\n";
				for(i=0;i<n;i++){
					cout<<b[i]<<" ";
					}
					cout<<"\n";
for(i=0;i<n;i++){
	for(j=0;j<n;j++){
		if(i!=j){
		c[l]=a[i]-a[j];
		d[k]=b[i]-b[j];
		t[s]=sqrt(c[l]*c[l]+d[k]*d[k]);
		s++;
		l++;
		k++;
	}
	l=0;
	k=0;
}}
for(i=0;i<s;i++){
	cout<<t[i]<<" ";}
	cout<<"\n";
	max=t[0];
for(i=0;i<s;i++){
	
	if(t[i]>max){
		max=t[i];
	}}
	cout<<max;
}

