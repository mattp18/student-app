import React, { useState } from "react";
import { Form, Input, Modal, Button } from "antd";
import axios from "axios";

function PopUpForm() {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const layout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 16 },
  };

  // const dataForm = new FormData();
  // dataForm.append("name", this.addStudent.);
  // dataForm.append("email", this.state.email);
  // dataForm.append("gender", this.state.gender);

  const onFinish = (values: any) => {
    console.log(typeof student);
    console.log(values);

    axios
      .post("/api/v1/students/addStudent", values)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const validateMessages = {
    required: "${label} is required!",
    types: {
      email: "${label} is not a valid email!",
      number: "${label} is not a valid number!",
    },
    number: {
      range: "${label} must be between ${min} and ${max}",
    },
  };

  return (
    <div>
      <Button type="primary" onClick={showModal}>
        Add Student
      </Button>
      <Modal
        title="Add a Student"
        visible={isModalVisible}
        onOk={handleOk}
        onCancel={handleCancel}
      >
        <Form
          {...layout}
          name="nest-messages"
          onFinish={onFinish}
          validateMessages={validateMessages}
        >
          <Form.Item name="name" label="Name" rules={[{ required: true }]}>
            <Input />
          </Form.Item>
          <Form.Item name="email" label="Email" rules={[{ type: "email" }]}>
            <Input />
          </Form.Item>
          <Form.Item name="gender" label="Gender">
            <Input />
          </Form.Item>
          <Form.Item wrapperCol={{ ...layout.wrapperCol, offset: 8 }}>
            <Button type="primary" htmlType="submit">
              Submit
            </Button>
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
}

export default PopUpForm;
