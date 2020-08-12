import os
import sys
import cv2
import pytesseract


def main():
    # I have no idea how to do better on Windows
    os.environ['PATH'] = 'C:\\Program Files\\Tesseract-OCR'

    imagepath = sys.argv[1]
    text = pytesseract.image_to_string(imagepath)
    print(text)
    return text


if __name__ == "__main__":
    main()
