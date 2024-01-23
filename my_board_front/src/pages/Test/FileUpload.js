import React, { useState } from 'react';

const ImageUpload = () => {
  const [selectedImage, setSelectedImage] = useState(null);

  const handleImageChange = (e) => {
    setSelectedImage(e.target.files[0]);
  };

  const handleUpload = () => {
    const formData = new FormData();
    formData.append('image', selectedImage);

    fetch('http://localhost:8080/api/upload', {
      method: 'POST',
      body: formData,
    })
      .then(response => response.text())
      .then(data => {
        console.log('Image uploaded successfully:', data);
      })
      .catch(error => {
        console.error('Error uploading image:', error);
      });
  };

  return (
    <div>
      <input type="file" onChange={handleImageChange} />
      <button onClick={handleUpload}>Upload Image</button>
    </div>
  );
};

export default ImageUpload;
