import React, { useState } from 'react';

const ImageUpload = () => {
  const [selectedImage, setSelectedImage] = useState(null);
  const [images, setImages] = useState([]);
  const [text, setText] = useState('');

  const handleTextChange1 = (e) => {
    setText(e.target.value);
  };

  const handleImageChange1 = (e) => {
    const selectedImages = Array.from(e.target.files);
    setImages(selectedImages);
  };

  const handleUpload1 = () => {
    const formData = new FormData();
    formData.append('title', text);

    images.forEach((image, index) => {
      formData.append('files', image);
    });

    fetch('http://localhost:8080/api/uploadFiles', {
      method: 'POST',
      body: formData,
    })
      .then(response => response.text())
      .then(data => {
        console.log('Post created successfully:', data);
      })
      .catch(error => {
        console.error('Error creating post:', error);
      });
  };

  const handleImageChange = (e) => {
    setSelectedImage(e.target.files[0]);
  };

  const handleUpload = () => {
    const formData = new FormData();
    formData.append('image', selectedImage);
    formData.append('text', "hello world")

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
        <h2>1. 이미지 하나 보내기</h2> 
      <input type="file" onChange={handleImageChange} />
      <br></br>
      <button onClick={handleUpload}>Upload Image</button>
      <br></br>
      <br></br>
      <h2>2. 여러 이미지, 글 함께 보내기</h2> 
      <textarea value={text} onChange={handleTextChange1} placeholder="Enter your post text" />
      <br></br>
      <input type="file" onChange={handleImageChange1} multiple />
      <br></br>
      <button onClick={handleUpload1}>Create Post</button>
    </div>
  );
};

export default ImageUpload;
