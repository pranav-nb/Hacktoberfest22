//C++ solution for Leetcode Hard problem Median of two sorted arrays Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2)
    {
        vector<double> v;
        int i=0,j=0;
        int m=nums1.size();
        int n=nums2.size();
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                v.push_back(nums1[i]);
                i++;
            }
            else {
                v.push_back(nums2[j]);
                j++;
            }
        }
        while(i<m){
            v.push_back(nums1[i]);
            i++;
        }
        while(j<n){
            v.push_back(nums2[j]);
            j++;
        }
        double mean=0;
        if((m+n)%2) return v[(m+n)/2];
        else return (v[(m+n)/2]+v[((m+n)/2)-1])/2;
        
    }
};
