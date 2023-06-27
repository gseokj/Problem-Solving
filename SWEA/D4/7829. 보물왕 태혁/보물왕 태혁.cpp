#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int T;
    cin >> T;
    for (int t = 1; t <= T; ++t) {
        int n;
        cin >> n;
        vector<int> d(n);
        for (int i = 0; i < n; ++i) cin >> d[i];
        sort(d.begin(), d.end());
        cout << "#" << t << " " << d[0] * d.back() << endl;
    }
    return 0;
}
