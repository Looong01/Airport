#!/usr/bin/python
# -*- coding: latin-1 -*-
import cv2
import sys

userJPD=sys.argv[1]

cap = cv2.VideoCapture(0)  # 打开摄像头

while (1):
    # get a frame
    ret, frame = cap.read()
    # show a frame
    cv2.imshow("capture", frame)  # 生成摄像头窗口

    if cv2.waitKey(1) & 0xFF == ord('q'):  # 如果按下q 就截图保存并退出
        # cv2.imwrite("/Users/gody/Desktop/Airport/src/main/resources/JPG/"+userJPD+".jpg", frame)  # 保存路径
        cv2.imwrite("./src/main/resources/JPG/"+userJPD+".jpg", frame)  # 保存路径
        break

cap.release()
cv2.destroyAllWindows()
