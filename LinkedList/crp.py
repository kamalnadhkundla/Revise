import tkinter as tk
from tkinter import filedialog, messagebox
from PIL import Image, ImageTk
import cv2
import os
from cryptography.fernet import Fernet

# Save encrypted image file
def encrypt_image():
    filepath = filedialog.askopenfilename(filetypes=[("Image Files", "*.png *.jpg *.jpeg")])
    if not filepath:
        return

    # Read image as bytes
    with open(filepath, "rb") as f:
        original_data = f.read()

    # Generate AES key
    key = Fernet.generate_key()
    cipher = Fernet(key)
    encrypted_data = cipher.encrypt(original_data)

    # Save encrypted image
    encrypted_path = filepath + ".encrypted"
    with open(encrypted_path, "wb") as f:
        f.write(encrypted_data)

    # Show blurred preview
    img = cv2.imread(filepath)
    blurred = cv2.GaussianBlur(img, (25, 25), 0)
    cv2.imwrite("blurred_preview.png", blurred)
    preview_image("blurred_preview.png", "Encrypted (Preview)")

    # Save key to file
    key_path = filedialog.asksaveasfilename(defaultextension=".key", filetypes=[("Key File", "*.key")])
    if key_path:
        with open(key_path, "wb") as f:
            f.write(key)
        messagebox.showinfo("Success", f"Image encrypted!\nKey saved to: {key_path}")
    else:
        messagebox.showwarning("Warning", "Encryption key not saved!")

# Decrypt encrypted file
def decrypt_image():
    filepath = filedialog.askopenfilename(filetypes=[("Encrypted Files", "*.encrypted")])
    if not filepath:
        return

    key_path = filedialog.askopenfilename(title="Select Key File", filetypes=[("Key File", "*.key")])
    if not key_path:
        return

    try:
        with open(key_path, "rb") as f:
            key = f.read()
        cipher = Fernet(key)

        with open(filepath, "rb") as f:
            encrypted_data = f.read()

        decrypted_data = cipher.decrypt(encrypted_data)

        # Save and show decrypted image
        original_image_path = filepath.replace(".encrypted", "_decrypted.png")
        with open(original_image_path, "wb") as f:
            f.write(decrypted_data)

        preview_image(original_image_path, "Decrypted Image")
        messagebox.showinfo("Success", f"Image decrypted!\nSaved to: {original_image_path}")
    except Exception as e:
        messagebox.showerror("Error", f"Decryption failed:\n{e}")

# Image preview utility
def preview_image(path, title):
    top = tk.Toplevel()
    top.title(title)
    img = Image.open(path)
    img = img.resize((300, 300))
    img_tk = ImageTk.PhotoImage(img)
    panel = tk.Label(top, image=img_tk)
    panel.image = img_tk
    panel.pack()

# GUI Setup
root = tk.Tk()
root.title("Image Encryptor & Decryptor")
root.geometry("400x250")

label = tk.Label(root, text="Secure Image Encryptor", font=("Helvetica", 16))
label.pack(pady=20)

encrypt_btn = tk.Button(root, text="Encrypt Image", command=encrypt_image, width=20)
encrypt_btn.pack(pady=10)

decrypt_btn = tk.Button(root, text="Decrypt Image", command=decrypt_image, width=20)
decrypt_btn.pack(pady=10)

root.mainloop()
