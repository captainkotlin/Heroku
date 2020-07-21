import sys
import cv2
import pytesseract


def main():
    imagepath = sys.argv[1]
    img = cv2.imread(imagepath)
    text = pytesseract.image_to_string(imagepath)
    print(text)
    return text


if __name__ == "__main__":
    main()
