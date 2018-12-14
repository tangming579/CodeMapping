```c#
class Program
    {
        public const string EXCHANGE_A = "my-mq-exchange_A";
        public const string EXCHANGE_B = "my-mq-exchange_B";
        public const string EXCHANGE_C = "my-mq-exchange_C";

        public const string QUEUE_A = "QUEUE_A";
        public const string QUEUE_B = "QUEUE_B";
        public const string QUEUE_C = "QUEUE_C";

        public const string ROUTINGKEY_A = "spring-boot-routingKey_A";
        public const string ROUTINGKEY_B = "spring-boot-routingKey_B";
        public const string ROUTINGKEY_C = "spring-boot-routingKey_C";

        static void Main(string[] args)
        {
            var factory = new ConnectionFactory();
            factory.HostName = "154.8.184.140";
            factory.UserName = "admin";//用户名
            factory.Password = "admin";//密码
            factory.Port = 5672;
            factory.VirtualHost = "/";
            //factory.Uri = new Uri("amqp://admin:admin@154.8.184.140:5672/vhost");

            using (var connection = factory.CreateConnection())
            {
                using (var channel = connection.CreateModel())
                {
                    channel.QueueDeclare(QUEUE_A, true, false, false, null);
                    channel.ExchangeDeclare(QUEUE_A, ExchangeType.Direct, true, false, null);
                    channel.QueueBind(QUEUE_A, EXCHANGE_A, ROUTINGKEY_A, null);

                    var consumer = new EventingBasicConsumer(channel);
                    channel.BasicConsume(QUEUE_A, false, consumer);


                    consumer.Received += (model, ea) =>
                    {
                        var body = ea.Body;
                        var message = Encoding.UTF8.GetString(body);
                        //回复确认
                        channel.BasicAck(ea.DeliveryTag, false);
                        Console.WriteLine("已接收： {0}", message);
                    };
                    Console.ReadLine();
                }
            }
        }
    }
```

