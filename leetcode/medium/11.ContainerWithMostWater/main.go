package main

// brute force
//func maxArea(height []int) int {
//	n, ret := len(height), 0
//	for i := 0; i < n; i++ {
//		for j := i; j < n; j++ {
//			height := Min(height[i], height[j])
//			ret = Max(ret, height*(j-i))
//		}
//	}
//	return ret
//}

func maxArea(height []int) int {
	ret := 0

	for l, r := 0, len(height)-1; l < r; {
		ret = Max(ret, (r-l)*Min(height[l], height[r]))
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return ret
}

func Max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
func Min(x, y int) int {
	if y < x {
		return y
	}
	return x
}
