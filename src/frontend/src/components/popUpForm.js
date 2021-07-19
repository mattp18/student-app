import React, { useState } from "react";
import { Form, Input, Modal, Button, Select } from "antd";
import axios from "axios";
import {
  successNotification,
  infoNotification,
  errorNotification,
  warningNotification,
} from "./Notification";

const { Option } = Select;

function PopUpForm({ fetchStudents }) {
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [form] = Form.useForm();

  const layout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 16 },
  };

  const onFinish = (values) => {
    console.log(typeof student);
    console.log(values);

    axios
      .post("/api/v1/students/addStudent", values)
      .then(function (response) {
        console.log(response);
        form.resetFields();
        successNotification(
          "Student successfully added!",
          `Student ${values.name} was added to the system`
        );
        fetchStudents();
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

  const onGenderChange = (value: string) => {
    switch (value) {
      case "male":
        form.setFieldsValue({ note: "Hi, man!" });
        return;
      case "female":
        form.setFieldsValue({ note: "Hi, lady!" });
        return;
    }
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
          form={form}
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
            <Select
              placeholder="Select an option"
              onChange={onGenderChange}
              allowClear
            >
              <Option value="MALE">Male</Option>
              <Option value="FEMALE">Female</Option>
            </Select>
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
