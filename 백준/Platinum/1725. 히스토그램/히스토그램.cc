#include <iostream>
#include <stack>
#define N 100002

using namespace std;
typedef long long ll;

struct strc {
	int idx;
	ll h;
};

int n;
int idx;
ll ans = 0;
ll arr[N];

int main() {
	cin >> n;
	stack<strc> s;

	arr[n] = 0;

	for (int i = 0; i <= n; i++) {
		if (i < n) cin >> arr[i];

		idx = i;

		while (!s.empty() && s.top().h >= arr[i]) {
			idx = s.top().idx;
			ll w = ll(i) - ll(idx);
			ans = max(ans, w * s.top().h);
			s.pop();
		} 
		
		s.push({ idx, arr[i] });
	} 
    
	cout << ans << '\n';
}