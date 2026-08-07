
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peak(mountainArr);

        int firstTry = binarySearch(mountainArr, target, 0, peak, true);

        if(firstTry != -1){
            return firstTry;
        }else{
            return binarySearch(mountainArr, target, peak, mountainArr.length()-1, false);
        }
    }

    public int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean asc){
        while(start<=end){
            int mid=start+(end-start)/2;

            if(mountainArr.get(mid)==target){
                return mid;
            }

            if(asc){
                if(target<mountainArr.get(mid)){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(target>mountainArr.get(mid)){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }

        return -1;
    }

    public int peak(MountainArray mountainArr){
        int start=0;
        int end= mountainArr.length()-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        return start;
    }
}